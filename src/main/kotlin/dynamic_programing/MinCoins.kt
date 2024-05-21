package dynamic_programing

import java.util.Stack
import kotlin.math.min

class MinCoins {

    // Imagine a tree of possibilities with amount as the root
    // each edge us a coin value reduction from amount
    // Build up a cache from bottom to up
    fun coinChange(coins: List<Int>, amount: Int) {
        val cache = Array(amount + 1) { Int.MAX_VALUE }
        cache[0] = 0

        for(currentAmount in 0..amount) {
            for (coin in coins) {
                if (currentAmount - coin >= 0) {
                    // minimum of amount of coins
                    // arguments are the amount of coins for the currentAmount and 1 (new coin added) plus
                    // the amount of coins to build the remaining amount
                    cache[currentAmount] = min(cache[currentAmount], 1 + cache[currentAmount - coin])
                }
            }
        }
        println(cache.toList())
        println(cache[amount])
    }

    fun coinChangeRecursion(coins: MutableList<Int>, amount: Int, remaining: Int) {
        if (remaining < 0) {
            return
        }
        if (remaining == 0) {
            println(remaining)
            // we've found it
        } else {
            for(i in 0..<coins.size) {
                if (remaining - coins[i] >= 0) {
                    val coin = coins[i]
                    coinChangeRecursion(tempCoins, amount, remaining - coin)
                    coins.add(i, coin)
                }
            }
//            if (currentCoin <= remaining) {
//                coinChangeRecursion(coins, amount, remaining - currentCoin)
//            }
//            coins.push(currentCoin)
        }
    }

}