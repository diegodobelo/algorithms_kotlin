package arrays

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ArraysAlgorithmsTest {

    private val subject = ArraysAlgorithms()

    @Test
    fun `check evens first odds last`() {
        assertEquals(arrayOf(2, 6, 5, 9, 3).toList(), subject.evenFirstOddLast(arrayOf(2, 3, 5, 6, 9)).toList())
    }
}