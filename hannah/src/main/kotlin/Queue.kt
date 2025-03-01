class Queue<T>(private val capacity: Int? = null) {
    private val elements: ArrayDeque<T> = initializeElements()
    private var head = 0
    private var tail = 0

    fun add(element: T): Boolean {
        if (capacity != null && tail - head >= capacity) throw IllegalStateException()
        elements.addLast(element)
        tail++
        println(elements)
        return true
    }

    fun offer(element: T): Boolean {
        if (capacity != null && tail - head >= capacity) return false
        elements.addLast(element)
        tail++
        return true
    }

    fun remove(): T {
        if (tail - head == 0) throw NoSuchElementException()
        println(elements)
        return elements[head++]
    }

    fun poll(): T? {
        if (tail - head == 0) return null
       return elements[head++]
    }

    fun element(): T {
        if (tail - head == 0) throw NoSuchElementException()
        return elements[head]
    }

    fun peek(): T? {
        if (tail - head == 0) return null
        return elements[head]
    }

    private fun initializeElements(): ArrayDeque<T> =
        if (capacity == null) ArrayDeque()
        else ArrayDeque(capacity)
}