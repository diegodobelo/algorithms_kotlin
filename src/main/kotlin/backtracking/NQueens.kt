package backtracking

class NQueens {

    private val column = mutableSetOf<Int>()
    private val positiveDiagonal = mutableSetOf<Int>()
    private val negativeDiagonal = mutableSetOf<Int>()

    fun solveNQueens(n: Int) {
        val board = Array(n) { Array(n) { 0 } }
        solve(board, 0)
    }

    private fun solve(board: Array<Array<Int>>, row: Int) {

        if (row == board.size) {
            printSolution(board)
        } else {
            for (col in board[0].indices) {
                if (isSafe(row, col)) {
                    board[row][col] = 1
                    column.add(col)
                    positiveDiagonal.add(row + col)
                    negativeDiagonal.add(row - col)

                    solve(board,row + 1)

                    board[row][col] = 0
                    column.remove(col)
                    positiveDiagonal.remove(row + col)
                    negativeDiagonal.remove(row - col)
                }
            }
        }

    }

    private fun isSafe(row: Int, col: Int): Boolean {
        for (i in 0..<row) {
            if (column.contains(col) ||
                positiveDiagonal.contains(row + col) ||
                negativeDiagonal.contains(row - col)
                ) {
                return false
            }
        }
        return true
    }

    private fun printSolution(board: Array<Array<Int>>) {
        for (row in board.indices) {
            for (col in board[0].indices) {
                if (board[row][col] == 1) {
                    print(" * ")
                } else {
                    print(" - ")
                }
            }
            println()
        }
        println()
    }


}