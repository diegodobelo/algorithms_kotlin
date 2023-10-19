package primitive_types

/**
 * Algorithms for primitive types
 */
class PrimitiveTypes {

    /**
     * Counts the number of bits set to 1 on an integer.
     * @param x The positive or negative integer to count the number of bits set to 1.
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
}