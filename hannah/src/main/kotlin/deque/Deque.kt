package deque

class Deque<T>(private val capacity: Int? = null) {
    private var elements = mutableListOf<T>()

    fun addFirst(element: T) {
        if (capacity != null && elements.size >= capacity) throw IllegalStateException()
        elements.add(0, element)
        println(elements)
    }

    fun addLast(element: T) {
        if (capacity != null && elements.size >= capacity) throw IllegalStateException()
        elements.add(element)
        println(elements)
    }

    fun offerFirst(element: T): Boolean {
        if (capacity != null && elements.size >= capacity) return false
        elements.add(0, element)
        println(elements)
        return true
    }

    fun offerLast(element: T): Boolean {
        if (capacity != null && elements.size >= capacity) return false
        elements.add(element)
        println(elements)
        return true
    }

    fun removeFirst(): T {
        if (elements.isEmpty()) throw NoSuchElementException()
        val result: T = elements.removeAt(0)
        println(elements)
        return result
    }

    fun removeLast(): T {
        if (elements.isEmpty()) throw NoSuchElementException()
        val result: T = elements.removeAt(elements.lastIndex)
        println(elements)
        return result

        // return elements.removeAt(elements.lastIndex)
    }

    fun pollFirst(): T? {
        if (elements.isEmpty()) return null
        val result: T = elements.removeAt(0)
        println(elements)
        return result
//        return elements.removeAt(0)
    }

    fun pollLast(): T? {
        if (elements.isEmpty()) return null
        val result: T = elements.removeAt(elements.lastIndex)
        println(elements)
        return result
//        return elements.removeAt(elements.lastIndex)
    }

    fun getFirst(): T {
        if (elements.isEmpty()) throw NoSuchElementException()
        return elements[0]
    }

    fun getLast(): T {
        if (elements.isEmpty()) throw NoSuchElementException()
        return elements[elements.lastIndex]
    }

    fun peekFirst(): T? {
        if (elements.isEmpty()) return null
        return elements[0]
    }

    fun peekLast(): T? {
        if (elements.isEmpty()) return null
        return elements[elements.lastIndex]
    }
}