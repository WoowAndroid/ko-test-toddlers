package datastructure

interface Queue<T: Any?> {
    val front: Int
    val rear: Int
    val size: Int

    fun enqueue(item: T)

    fun dequeue(): T?

    fun peek(): T?

    fun isEmpty(): Boolean

    fun isFull(): Boolean
}

class QueueWithIndex<T: Any?>(private val maxSize: Int) : Queue<T> {
    override var front: Int = 0
        private set
    override var rear: Int = -1
        private set
    override val size: Int
        get() = rear - front + 1
    private val queue: Array<T?> = Array<Any?>(maxSize) {null} as Array<T?>

    init {
        require(maxSize > 0) { "큐의 크기는 0보다 커야합니다." }
    }

    override fun enqueue(item: T) {
        if (!isFull()) queue[++rear] = item
        else println("더 이상 넣을 수 없습니다. rear 크기: $rear, MaxSize: $maxSize")
    }

    override fun dequeue(): T? {
        return if (!isEmpty()) queue[front++]
        else {
            println("큐가 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun peek(): T? {
        return if (!isEmpty()) queue[front]
        else {
            println("큐가 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun isEmpty(): Boolean = front > rear

    override fun isFull(): Boolean = rear >= maxSize - 1
}

class CircularQueue<T: Any?>(private val maxSize: Int) : Queue<T> {
    override var front: Int = 0
        get() = field % maxSize
        private set
    override var rear: Int = -1
        get() = field % maxSize
        private set
    override var size: Int = 0
        private set
    private val queue: Array<T?> = Array<Any?>(maxSize) {null} as Array<T?>

    init {
        require(maxSize > 0) { "큐의 크기는 0보다 커야합니다." }
    }

    override fun enqueue(item: T) {
        if (!isFull()) {
            queue[++rear] = item
            size++
        }
        else println("더 이상 넣을 수 없습니다. 현재 크기: $size, MaxSize: $maxSize")
    }

    override fun dequeue(): T? {
        return if (!isEmpty()) {
            size--
            queue[front++]
        }
        else {
            println("큐가 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun peek(): T? {
        return if (!isEmpty()) queue[front]
        else {
            println("큐가 비어있습니다. null을 반환합니다.")
            null
        }
    }

    override fun isEmpty(): Boolean = size == 0

    override fun isFull(): Boolean = size == maxSize
}
