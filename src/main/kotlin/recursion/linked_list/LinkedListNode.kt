package recursion.linked_list

data class LinkedListNode<T>(
    val value: T,
    var next: LinkedListNode<T>? = null
) {
    companion object {
        fun createSampleLinkedList(): LinkedListNode<String> {
            val a = LinkedListNode("a")
            val b = LinkedListNode("b")
            val c = LinkedListNode("c")
            val d = LinkedListNode("d")
            val e = LinkedListNode("e")
            val f = LinkedListNode("f")

            a.next = b
            b.next = c
            c.next = d
            d.next = e
            e.next = f

            return a
        }

        fun <T> printLL(ll: LinkedListNode<T>?) {
            var current = ll
            while (current != null) {
                print(current.value)
                current = current.next
            }
            println()
        }
    }
}