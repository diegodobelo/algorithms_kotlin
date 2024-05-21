package arrays_algorithms

import java.util.Collections

/**
 * Algorithms using arrays
 */
class ArraysAlgorithms {

    /**
     * Rearranges an array in place by swapping odd numbers with even numbers so that the even numbers appears first.
     * The idea is to keep 2 variables to hold a start index and an end index. When the start index finds an odd number
     * it swaps with the number at the end index.
     * @param x the array of integers to be rearranged.
     * @return the rearranged array. Note that the array passed as parameter us rearranged in place and returned.
     */
    fun evenFirstOddLast(x: Array<Int>): Array<Int> {
        var startIndex = 0
        var endIndex = x.size - 1
        while (startIndex < endIndex) {
            if (x[startIndex] % 2 == 0) { // is even, just move on
                ++startIndex
            } else { // is odd, swap
                x.swap(startIndex, endIndex)
                --endIndex
            }
        }
        return x
    }

    private fun <T> Array<T>.swap(i: Int, j: Int) {
        val oddValue = this[i]
        this[i] = this[j]
        this[j] = oddValue
    }

    fun arbitraryPrecisionIntPlusOne(x: Array<Int>): Array<Int> {
        val tempX = mutableListOf(*x)
        val last = tempX.last()
        tempX[tempX.lastIndex] = last + 1
        (tempX.size - 1 downTo  1).forEach {
            if (tempX[it] == 10) {
                tempX[it] = 0
                tempX[it - 1] = tempX[it - 1] + 1
            }
        }
        if (tempX[0] == 10) {
            tempX[0] = 1
            tempX.add(0)
        }
        return tempX.toTypedArray()
    }
}