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

    @Nested
    inner class `Check parity of a long by doing xor of first half with second half of a Long` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals(0, subject.halfXorParity(0))
            assertEquals(0, subject.halfXorParity(3))
            assertEquals(0, subject.halfXorParity(5))
            assertEquals(1, subject.halfXorParity(19))
            assertEquals(1, subject.halfXorParity(127))
        }

        @Test
        fun `negative numbers`() {
            assertEquals(0, subject.halfXorParity(-1))
            assertEquals(1, subject.halfXorParity(-3))
            assertEquals(0, subject.halfXorParity(-19))
        }
    }


    @Nested
    inner class `Swap bits of a Long` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals("0000000000000000000000000010001", 17L.bits())
            assertEquals("0000000000000000000000010000001", subject.swapBits(17L, 4, 7).bits())

            assertEquals("0000000000000000000010100001101", 1293L.bits())
            assertEquals("0000000000000000100010100000101", subject.swapBits(1293L, 14, 3).bits())

            // DO NOT SWAP
            assertEquals("0000000000000000000000000000011", 3L.bits())
            assertEquals("0000000000000000000000000000011", subject.swapBits(3L, 0, 1).bits())
        }

        @Test
        fun `negative numbers`() {
            assertEquals("1111111111111111111111111101111", (-17L).bits())
            assertEquals("1111111111111111111111101111111", subject.swapBits(-17L, 4, 7).bits())

            assertEquals("1111111111111111111101011110011", (-1293L).bits())
            assertEquals("1111111111111111011101011111011", subject.swapBits(-1293L, 14, 3).bits())
        }
    }

    @Nested
    inner class `Reverse digits of an Integer` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals(245, subject.reverseDigitsOfInt(542))
            assertEquals(1367, subject.reverseDigitsOfInt(7631))
            assertEquals(1111, subject.reverseDigitsOfInt(1111))
            assertEquals(0, subject.reverseDigitsOfInt(0))
        }

        @Test
        fun `negative numbers`() {
            assertEquals(-245, subject.reverseDigitsOfInt(-542))
            assertEquals(-1367, subject.reverseDigitsOfInt(-7631))
            assertEquals(-1111, subject.reverseDigitsOfInt(-1111))
        }
    }

    @Nested
    inner class `Check if integer is palindrome` {

        private val subject = PrimitiveTypes()

        @Test
        fun `positive numbers`() {
            assertEquals(false, subject.isPalindrome(542))
            assertEquals(true, subject.isPalindrome(1234554321))
            assertEquals(true, subject.isPalindrome(56788765))
            assertEquals(true, subject.isPalindrome(11))
            assertEquals(false, subject.isPalindrome(772177))
        }

        @Test
        fun `negative numbers`() {
            assertEquals(false, subject.isPalindrome(-542))
            assertEquals(false, subject.isPalindrome(-1234554321))
            assertEquals(false, subject.isPalindrome(-56788765))
            assertEquals(false, subject.isPalindrome(-11))
            assertEquals(false, subject.isPalindrome(-772177))
        }
    }



}