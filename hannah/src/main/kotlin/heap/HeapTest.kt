package heap

fun maxHeapTestForMadeByMe() {
    val maxHeap = MaxHeap()

    maxHeap.insert(1)
    maxHeap.insert(10)
    maxHeap.insert(5)
    maxHeap.insert(4)
    maxHeap.insert(7)
    maxHeap.delete()
    maxHeap.insert(15)
    maxHeap.delete()
    maxHeap.insert(12)
    maxHeap.insert(9)
    maxHeap.delete()
    maxHeap.delete()
    println(maxHeap.elements)
}

fun minHeapTestForMadeByMe() {
    val minHeap = MinHeap()

    minHeap.insert(1)
    minHeap.insert(10)
    minHeap.insert(5)
    minHeap.insert(4)
    minHeap.insert(7)
    minHeap.delete()
    minHeap.insert(15)
    minHeap.delete()
    minHeap.insert(12)
    minHeap.insert(9)
    minHeap.delete()
    minHeap.delete()
    println(minHeap.elements)
}

