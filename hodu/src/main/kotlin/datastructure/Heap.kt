package datastructure

interface Heap {
    val endNodeIndex: Int

    fun insert(item: Long)

    fun delete(): Long

    fun isFull(): Boolean

    fun isEmpty(): Boolean
}
