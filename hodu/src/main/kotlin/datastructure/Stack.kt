package datastructure

interface Stack<T: Any?> {
    val top: Int
    val size: Int

    fun push(item: T)

    fun pop(): T?

    fun peek(): T?

    fun isEmpty(): Boolean
}

class StackUsingTop<T : Any?>(private val maxSize: Int) : Stack<T> {
    override var top: Int = -1
        private set
    override val size: Int
        get() = stack.size
    private val stack: Array<T?> = Array<Any?>(maxSize) {null} as Array<T?>

    init {
        require(maxSize > 0) { "스택의 크기는 0보다 커야합니다." }
    }

    override fun push(item: T) {
        if (top < maxSize - 1) stack[++top] = item
        else println("더 이상 넣을 수 없습니다. Max Size: $maxSize")
    }

    override fun pop(): T? {
        return if (!isEmpty()) stack[top--]
        else {
            println("스택이 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun peek(): T? {
        return if (!isEmpty()) stack[top]
        else {
            println("스택이 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun isEmpty(): Boolean = top < 0
}
