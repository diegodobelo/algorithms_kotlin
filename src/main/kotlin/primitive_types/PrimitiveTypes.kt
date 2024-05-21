package primitive_types

import arrays_algorithms.ArraysAlgorithms
import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sign

/**
 * Algorithms for primitive types.
 */
class PrimitiveTypes {

    /**
     * Counts the number of bits set to 1 on an integer.
     * It applies a mask to get the rightmost bit (tempX and 1), and adds the value of that bit (0 or 1) to numBits.
     * Then it does an unsigned shift right and repeats the process until the value of tempX is 0.
     * @param x The positive or negative integer to count the number of bits set to 1.
     * @return The amount of bits set to 1.
     */
    fun countBits(x: Int): Int {
        var numBits = 0
        var tempX = x
        while (tempX != 0) {
            numBits += tempX and 1
            tempX = tempX ushr 1
        }
        return numBits
    }

    /**
     * Checks the parity of a long.
     * It toggles the value of result (1 to 0 or 0 to 1) by performing a xor with the first bit of the input.
     * @param x the long value to check parity.
     * @return 1L if odd, 0L if even.
     */
    fun bruteForceParity(x: Long): Long {
        var result = 0L
        var tempX = x
        while (tempX != 0L) {
            result = result xor (tempX and 1L)
            tempX = tempX ushr 1
        }
        return result
    }

    /**
     * Checks the parity of a long by clearing the last bit set to 1.
     * It clears the last bit set to 1 od the given long by doing the trick (x & (x - 1)).
     * @param x the long value to check parity.
     * @return 1 if odd, 0 if even.
     */
    fun fasterParity(x: Long): Int {
        var result = 0
        var tempX = x
        while (tempX != 0L) {
            result = result xor 1
            tempX = tempX and (tempX - 1)
        }
        return result
    }

    /**
     * Checks parity of a long by performing a xor of half of a Long with the other half of the same Long.
     * Then do the same with half of the half and so on. Finally, get the last bit by performing an 'and' to get the
     * last bit. If you do a xor on every bit of a long you will be calculating the parity. As xor is commutative and
     * associative you can perform xor with groups of bits.
     * @param x the long value to check parity.
     * @return 1L if odd, 0L if even.
     */
    fun halfXorParity(x: Long): Long {
        var tempX = x
        tempX = tempX xor (tempX ushr 32)
        tempX = tempX xor (tempX ushr 16)
        tempX = tempX xor (tempX ushr 8)
        tempX = tempX xor (tempX ushr 4)
        tempX = tempX xor (tempX ushr 2)
        tempX = tempX xor (tempX ushr 1)
        return tempX and 1
    }

    /**
     * Swaps bits on a Long. It checks if the bits on position i and j are not the same. As the bits only can have
     * value 1 or 0, we just need to invert them on each position when they are different. To do that we just need to
     * apply a xor with 1, because 1 xor 1 = 0 and 0 xor 1 = 1.
     * @param x the Long to have bits swapped.
     * @param i the position of the first bit.
     * @param j the position of the second bit.
     * @return The swapped Long.
     */
    fun swapBits(x: Long, i: Int, j: Int): Long {
        var result = x
        if ((x ushr i) and 1 != (x ushr j) and 1) {
            val bitmask = (1L shl i) or (1L shl j)
            result = result xor bitmask
        }
        return result
    }

    /**
     * Reverses the digits of an Int. e.g. 245 becomes 542, -8539 becomes 9358.
     * The idea is to extract the first (rightmost digit) by applying a mod 10. Then we drop that first digit by
     * dividing by 10. Next we multiply the temporary result by 10 and sum it with last digit again.
     * @param x the Integer to have digits reversed.
     */
    fun reverseDigitsOfInt(x: Int): Int {
        var result = 0
        var xRemaining = abs(x)
        while (xRemaining != 0) {
            result = result * 10 + xRemaining % 10
            xRemaining /= 10
        }
        return result * x.sign
    }

    /**
     * Checks if an integer is a palindrome. The idea is to extract most significant bit, extract least significant bit,
     * and check if they are equal. Then drop both digits and repeat the process. If they are always equal throughout the
     * process, the integer is a palindrome. Negative numbers are never a palindrome because of the negative sign.
     * @param x The Integer to check if is a palindrome.
     */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var tempX = x
        // We can determine de number of digits by applying log10, which basically tells the number of times
        // we can divide an int by 10 until it gets to a number < 10. If it is 2987 for example, we get 298 -> 29 -> 2
        val numDigits = (log10(x.toDouble()) + 1).toInt()
        var mostSignificantDigitMask = (10.0.pow(numDigits - 1)).toInt()
        repeat( numDigits/2) {
            val mostSignificantDigit = tempX / mostSignificantDigitMask
            val leastSignificantDigit = tempX % 10
            if (mostSignificantDigit != leastSignificantDigit) {
                return false
            }
            tempX %= mostSignificantDigitMask // Drop the first digit (most significant)
            tempX /= 10 // Drop the last digit (least significant)
            mostSignificantDigitMask /= 100 // we divide by 100 because we dropped 2 digits
        }

        return true
    }
}

fun blastoise(block: ArraysAlgorithms.() -> Unit) {
    val arraysAlgorithms = ArraysAlgorithms()
    block(arraysAlgorithms)
}

fun Long.bits() : String {
    val stringBuilder = StringBuilder()
    var temp = this
    repeat((0..<31).count()) {
        stringBuilder.append(temp and 1)
        temp = temp ushr 1
    }
    return stringBuilder.reverse().toString()
}