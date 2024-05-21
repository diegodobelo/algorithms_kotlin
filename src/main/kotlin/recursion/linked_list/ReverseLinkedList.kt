package recursion.linked_list

class ReverseLinkedList {

    fun reverse(linkedList: LinkedListNode<String>?) : LinkedListNode<String>?{
        if (linkedList == null) {
            return null
        }
        var current = linkedList
        var prev: LinkedListNode<String>? = null
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }

    fun reverseRecursive(head: LinkedListNode<String>?, prev: LinkedListNode<String>?): LinkedListNode<String>? {
        if (head == null) return prev
        val next = head.next
        head.next = prev
        return reverseRecursive(next, head)
    }
}