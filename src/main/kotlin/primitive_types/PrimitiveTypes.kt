package primitive_types

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
     * @return 1L if odd, 0L if even.
     */
    fun fasterParity(x: Long): Long {
        var result = 0L
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
}