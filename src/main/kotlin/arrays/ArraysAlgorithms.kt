package arrays

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
                val oddValue = x[startIndex]
                x[startIndex] = x[endIndex]
                x[endIndex] = oddValue
                --endIndex
            }
        }
        return x
    }
}