package recursion.binary_tree

import java.util.Stack

class TraverseDFS {

    fun traverse(root: Node) {
        val stack = Stack<Node>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val current = stack.pop()
            println(current.value)
            current.left?.let { stack.push(it) }
            current.right?.let { stack.push(it) }
        }
    }

    fun traverseRecursive(root: Node?) {
        if (root == null) return
        println(root.value)
        traverseRecursive(root.left)
        traverseRecursive(root.right)
    }

}