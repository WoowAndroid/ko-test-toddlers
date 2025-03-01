package datastructure

interface Stack<T: Any?> {
    fun push(item: T)

    fun pop(): T?

    fun peek(): T?

    fun isEmpty(): Boolean

}

class StackUsingTop<T : Any?>(size: Int) : Stack<T> {
    private var top: Int = -1
    private val _stack: Array<T?> = Array<Any?>(size) {null} as Array<T?>
    private val maxSize = size

    init {
        require(size > 0)
    }

    override fun push(item: T) {
        if (top < maxSize - 1) _stack[++top] = item
        else println("더 이상 넣을 수 없습니다. Max Size: $maxSize")
    }

    override fun pop(): T? {
        return if (!isEmpty()) _stack[top--]
        else {
            println("스택이 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun peek(): T? {
        return if (!isEmpty()) _stack[top]
        else {
            println("스택이 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun isEmpty(): Boolean = top < 0
}
