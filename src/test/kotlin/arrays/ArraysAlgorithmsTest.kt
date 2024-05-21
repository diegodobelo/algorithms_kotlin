package arrays

import arrays_algorithms.ArraysAlgorithms
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@Suppress("ClassName")
class ArraysAlgorithmsTest {

    private val subject = ArraysAlgorithms()

    @Nested
    inner class `check evens first odds last` {
        @Test
        fun `arrays with positive integers`() {
            assertEquals(arrayOf(2, 6, 5, 9, 3).toList(), subject.evenFirstOddLast(arrayOf(2, 3, 5, 6, 9)).toList())
            assertEquals(arrayOf(4, 6, 0, 3, 9, 7, 35).toList(), subject.evenFirstOddLast(arrayOf(35, 6, 0, 7, 3, 9, 4)).toList())
            assertEquals(arrayOf(88, 4, 4, 0, 0, 7, 3, 3, 1).toList(), subject.evenFirstOddLast(arrayOf(1, 3, 4, 0, 0, 7, 4, 88, 3)).toList())
        }

        @Test
        fun `arrays with negative integers`() {
            assertEquals(arrayOf(-2, -6, -5, -9, -3).toList(), subject.evenFirstOddLast(arrayOf(-2, -3, -5, -6, -9)).toList())
            assertEquals(arrayOf(-4, -6, 0, -3, -9, -7, -35).toList(), subject.evenFirstOddLast(arrayOf(-35, -6, 0, -7, -3, -9, -4)).toList())
            assertEquals(arrayOf(-88, -4, -4, 0, 0, -7, -3, -3, -1).toList(), subject.evenFirstOddLast(arrayOf(-1, -3, -4, 0, 0, -7, -4, -88, -3)).toList())
        }

        @Test
        fun `arrays with integers`() {
            assertEquals(arrayOf(-2, 6, -5, -9, -3).toList(), subject.evenFirstOddLast(arrayOf(-2, -3, -5, 6, -9)).toList())
            assertEquals(arrayOf(-4, -6, 0, 3, -9, -7, -35).toList(), subject.evenFirstOddLast(arrayOf(-35, -6, 0, -7, 3, -9, -4)).toList())
            assertEquals(arrayOf(88, -4, 4, 0, 0, -7, -3, -3, -1).toList(), subject.evenFirstOddLast(arrayOf(-1, -3, 4, 0, 0, -7, -4, 88, -3)).toList())
        }
    }

    @Nested
    inner class `increment arbitrary-precision int array` {

        @Test
        fun `positive numbers`() {
            assertEquals(arrayOf(1, 2).toList(), subject.arbitraryPrecisionIntPlusOne(arrayOf(1, 1)).toList())
            assertEquals(arrayOf(1, 2, 3, 4, 5, 6, 7).toList(), subject.arbitraryPrecisionIntPlusOne(arrayOf(1, 2, 3, 4, 5, 6, 6)).toList())
        }

        @Test
        fun `positive numbers with carry`() {
            assertEquals(arrayOf(1, 2, 0).toList(), subject.arbitraryPrecisionIntPlusOne(arrayOf(1, 1, 9)).toList())
            assertEquals(arrayOf(1, 0, 0, 0).toList(), subject.arbitraryPrecisionIntPlusOne(arrayOf(9, 9, 9)).toList())
        }
    }

}