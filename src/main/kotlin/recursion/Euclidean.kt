package recursion

/**
 * The Euclidean algorithm, also known as Euclid’s algorithm, is an
 * algorithm for finding the greatest common divisor (GCD) between
 * two numbers. The GCD is the largest number that divides two
 * numbers without a remainder. The GCD of two numbers can be
 * found by making a list of factors for the two numbers, and finding
 * the largest factor that is in both sets. This works well for small
 * numbers, but it can become quite tedious and time consuming
 * for larger numbers. To address this problem, Euclid’s algorithm
 * can be used, which allows for the GCD of large numbers to be
 * found much faster. Euclid’s algorithm uses the principle that the
 * GCD of a set of two numbers does not change if you replace the
 * larger of the two with the remainder when you divide the larger of
 * the two by the smaller.
 *
 * https://www.csuohio.edu/sites/default/files/85-%202015.pdf
 *
 */
class Euclidean {
    fun gcd(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }

        return gcd(b, a % b)
    }
}