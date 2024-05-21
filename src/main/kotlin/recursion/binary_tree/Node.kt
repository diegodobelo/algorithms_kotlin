package recursion.binary_tree

data class Node(
    val value: String,
    var left: Node? = null,
    var right: Node? = null
) {

    companion object {
        fun createSampleTree() : Node {
            val a = Node("a")
            val b = Node("b")
            val c = Node("c")
            val d = Node("d")
            val e = Node("e")
            val f = Node("f")

            a.left = b
            a.right = c
            b.left = d
            b.right = e
            c.right = f
            return a
        }
    }
}