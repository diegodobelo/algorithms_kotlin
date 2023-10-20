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

    @Nested
    inner class `Check parity of a long using brute force` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals(0, subject.bruteForceParity(0))
            assertEquals(0, subject.bruteForceParity(3))
            assertEquals(0, subject.bruteForceParity(5))
            assertEquals(1, subject.bruteForceParity(19))
            assertEquals(1, subject.bruteForceParity(127))
        }

        @Test
        fun `negative numbers`() {
            assertEquals(0, subject.bruteForceParity(-1))
            assertEquals(1, subject.bruteForceParity(-3))
            assertEquals(0, subject.bruteForceParity(-19))
        }
    }

    @Nested
    inner class `Check parity of a long by clearing last bit set to 1` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals(0, subject.fasterParity(0))
            assertEquals(0, subject.fasterParity(3))
            assertEquals(0, subject.fasterParity(5))
            assertEquals(1, subject.fasterParity(19))
            assertEquals(1, subject.fasterParity(127))
        }

        @Test
        fun `negative numbers`() {
            assertEquals(0, subject.fasterParity(-1))
            assertEquals(1, subject.fasterParity(-3))
            assertEquals(0, subject.fasterParity(-19))
        }
    }



}