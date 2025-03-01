import java.util.EmptyStackException

class Stack<T> {
    private val elements = mutableListOf<T>()
    private var top: Int = -1

    fun push(element: T): T {
        elements.add(element)
        top++
        return element
    }

    fun pop(): T {
        val element = elements.removeLast()
        top--
        return element
    }

    fun peek(): T {
        if (empty()) throw EmptyStackException()
        return elements[top]
    }

    fun search(element: T): T {
        val lastIndex = elements.lastIndexOf(element)
        if (lastIndex < 0) return -1 as T
        return (elements.size - lastIndex) as T
    }

    fun empty(): Boolean = elements.size == 0
}
