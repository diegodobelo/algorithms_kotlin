package primitive_types

/**
 * Algorithms for primitive types
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
     * @param x the long value to check parity
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
}