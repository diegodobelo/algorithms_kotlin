package recursion

/**
 * Creating a program to generate all distinct binary trees with a specified number of nodes is a
 * complex task. It involves recursive algorithms to generate all possible combinations of left
 * and right subtrees. Below is a simple Kotlin program that uses a recursive approach
 * to generate all distinct binary trees with a specified number of nodes:
 */
class GenerateBinaryTrees {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) {
            return emptyList()
        }
        return generateTrees(1, n)
    }

    fun generateTrees(start: Int, end: Int): List<TreeNode?> {
        val result = mutableListOf<TreeNode?>()

        if (start > end) {
            result.add(null)
            return result
        }

        for (i in start..end) {
            val leftSubtrees = generateTrees(start, i - 1)
            val rightSubtrees = generateTrees(i + 1, end)

            for (left in leftSubtrees) {
                for (right in rightSubtrees) {
                    val root = TreeNode(i)
                    root.left = left
                    root.right = right
                    result.add(root)
                }
            }
        }

        return result
    }

    fun printTree(root: TreeNode?) {
        if (root == null) {
            return
        }
        printTree(root.left)
        println("${root.value} ")
        printTree(root.right)
    }


}

data class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)
