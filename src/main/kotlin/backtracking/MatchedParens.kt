package backtracking

class MatchedParens {

    fun matchedParens(n: Int) {
        val result = StringBuilder()
        generateMatchedParens(result, n, 0, 0)
    }

    private fun generateMatchedParens(result: StringBuilder, n: Int, open: Int, close: Int) {
        if (close == n) {
            // print result
            println(result.toString())
        } else {
            if (open < n) {
                result.append("(")
                generateMatchedParens(result, n, open + 1, close)
                result.deleteAt(result.length - 1)
            }

            if(close < open) {
                result.append(")")
                generateMatchedParens(result, n, open, close + 1)
                result.deleteAt(result.length - 1)
            }
        }
    }


}