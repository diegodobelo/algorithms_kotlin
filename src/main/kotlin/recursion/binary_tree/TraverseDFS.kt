package recursion.binary_tree

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class TraverseBFS {

    fun traverse(root: Node) {
        val queue: Queue<Node> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val current = queue.remove()
            println(current.value)
            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }
        }
    }

    // No recursive implementation because it uses queue and recursion is a stack of function call

}