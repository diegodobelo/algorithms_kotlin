package recursion.binary_tree

class BalanceBST {

    fun storeBSTNodes(root: Node?, result: MutableList<Node>) {
        if (root == null) return

        storeBSTNodes(root.left, result)
        result.add(root)
        storeBSTNodes(root.right, result)
    }

    fun buildTree(nodes: List<Node>, start: Int, end: Int): Node? {
        if (start > end) return null

        val mid = (start + end) / 2
        val node = nodes[mid]

        node.left = buildTree(nodes, start, mid - 1)
        node.right = buildTree(nodes, mid + 1, end)

        return node
    }

    fun balance(root: Node?): Node? {
        val result = mutableListOf<Node>()
        storeBSTNodes(root, result)
        return buildTree(result, 0, result.size -1)
    }

}