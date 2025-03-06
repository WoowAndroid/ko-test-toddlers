package heap

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

            if (leftChildIdx <= elements.lastIndex && elements[maxIdx] < elements[leftChildIdx]) maxIdx = leftChildIdx
            if (rightChildIdx <= elements.lastIndex && elements[maxIdx] < elements[rightChildIdx]) maxIdx = rightChildIdx
            if (maxIdx == currentIdx) break

            elements[currentIdx] = elements[maxIdx].also { elements[maxIdx] = elements[currentIdx] }
            currentIdx = maxIdx
        }
    }
}
