package backtracking

class RestoreIP {

    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()

        fun backtrack(path: MutableList<String>, index: Int) {
            if (path.size == 4) {
                if (index == s.length) {
                    result.add(path.joinToString("."))
                }
                return
            }
            if (index == s.length) {
                return
            }

            for (i in 1..3) {
                if (index + i > s.length) {
                    break
                }
                val segment = s.substring(index, index + i)
                if (validSegment(segment)) { // Check for leading zeros
                    path.add(segment)
                    backtrack(path, index + i)
                    path.removeLast()
                }
            }
        }

        backtrack(mutableListOf(), 0)
        return result
    }

    private fun validSegment(segment: String): Boolean {
        val segmentInt = segment.toIntOrNull()
        return segmentInt != null &&
                segmentInt in 0..256 && // Check is in range
                segment == segmentInt.toString() // exclude leading zeros
    }
}