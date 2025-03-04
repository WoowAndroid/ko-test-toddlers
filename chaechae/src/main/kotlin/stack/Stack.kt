package stack

class Stack<T> {
    private val items: MutableList<T> = mutableListOf()

    fun push(item: T) {
        items.add(item)
    }

    fun pop(): T {
        if (items.isEmpty()) throw NoSuchElementException(EMPTY_STACK_ERROR)
        return items.removeAt(index = items.size - 1)
    }

    fun peek(): T {
        if (items.isEmpty()) throw NoSuchElementException(EMPTY_STACK_ERROR)
        return items[items.size - 1]
    }


    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    companion object {
        private const val EMPTY_STACK_ERROR = "비었음 ㅋ"
    }
}