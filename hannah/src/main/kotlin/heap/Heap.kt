package heap

interface Heap {
    val elements: MutableList<Int>

    fun insert(element: Int)

    fun delete(): Int

    fun peek(): Int

    fun heapifyUp()

    fun heapifyDown()
}
