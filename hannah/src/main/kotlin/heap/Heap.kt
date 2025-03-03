package heap

interface Heap {
    val elements: MutableList<Int>

    fun insert(element: Int)

    fun delete(): Int

    fun peek(): Int

    fun heapifyUp()

    fun heapifyDown()
}

class MaxHeap : Heap {
    override val elements = mutableListOf<Int>()

    override fun insert(element: Int) {
        elements.add(element)
        heapifyUp()
    }

    override fun delete(): Int {
        val root = elements[0]
        elements[0] = elements.removeLast()
        heapifyDown()
        return root
    }

    override fun peek(): Int = elements[0]

    override fun heapifyUp() {
        var currentIdx = elements.lastIndex
        var parentIdx = (currentIdx - 1) / 2

        while (currentIdx > 0) {
            if (elements[parentIdx] >= elements[currentIdx]) break

            elements[parentIdx] = elements[currentIdx].also { elements[currentIdx] = elements[parentIdx] }
            currentIdx = parentIdx
            parentIdx = (currentIdx - 1) / 2
        }
    }

    override fun heapifyDown() {
        var currentIdx = 0

        while (true) {
            val leftChildIdx = currentIdx * 2 + 1
            val rightChildIdx = currentIdx * 2 + 2
            var maxIdx = currentIdx

            if (leftChildIdx <= elements.lastIndex && elements[maxIdx] < elements[leftChildIdx]) {
                maxIdx = leftChildIdx
            }
            if (rightChildIdx <= elements.lastIndex && elements[maxIdx] < elements[rightChildIdx]) {
                maxIdx = rightChildIdx
            }
            if (maxIdx == currentIdx) break

            elements[currentIdx] = elements[maxIdx].also { elements[maxIdx] = elements[currentIdx] }
            currentIdx = maxIdx
        }
    }
}

class MinHeap : Heap {
    override val elements = mutableListOf<Int>()

    override fun insert(element: Int) {
        elements.add(element)
        heapifyUp()
    }

    override fun delete(): Int {
        val root = elements[0]
        elements[0] = elements.removeLast()
        heapifyDown()
        return root
    }

    override fun peek(): Int = elements[0]

    override fun heapifyUp() {
        var current = elements.lastIndex
        var parent = (current - 1) / 2

        while (current > 0) {
            if (elements[current] >= elements[parent]) break

            elements[parent] = elements[current].also { elements[current] = elements[parent] }
            current = parent
            parent = (current - 1) / 2
        }
    }

    override fun heapifyDown() {
        var currentIdx = 0

        while (true) {
            val leftChildIdx = currentIdx * 2 + 1
            val rightChildIdx = currentIdx * 2 + 2
            var minIdx = currentIdx

            if (leftChildIdx <= elements.lastIndex && elements[minIdx] > elements[leftChildIdx]) minIdx = leftChildIdx
            if (rightChildIdx <= elements.lastIndex && elements[minIdx] > elements[rightChildIdx]) minIdx =
                rightChildIdx
            if (minIdx == currentIdx) break

            elements[currentIdx] = elements[minIdx].also { elements[minIdx] = elements[currentIdx] }
            currentIdx = minIdx
        }
    }
}