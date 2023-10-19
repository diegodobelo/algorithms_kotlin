package primitive_types

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


@Suppress("ClassName")
class PrimitiveTypesTest {

    @Nested
    inner class `Count bits in integer set to 1` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals(0, subject.countBits(0))
            assertEquals(2, subject.countBits(3))
            assertEquals(3, subject.countBits(19))
            assertEquals(7, subject.countBits(127))
        }

        @Test
        fun `negative numbers`() {
            assertEquals(32, subject.countBits(-1))
            assertEquals(31, subject.countBits(-3))
            assertEquals(30, subject.countBits(-19))
        }
    }



}