package heap

import java.util.*

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

fun maxHeapTestForByJava() {
    val maxHeap = PriorityQueue<Int>(reverseOrder())

    maxHeap.add(1)
    maxHeap.add(10)
    maxHeap.add(5)
    maxHeap.add(4)
    maxHeap.add(7)
    maxHeap.remove()
    maxHeap.add(15)
    maxHeap.remove()
    maxHeap.add(12)
    maxHeap.add(9)
    maxHeap.remove()
    maxHeap.remove()
    println(maxHeap)
}

fun minHeapTestForByJava() {
    val minHeap = PriorityQueue<Int>()

    minHeap.add(1)
    minHeap.add(10)
    minHeap.add(5)
    minHeap.add(4)
    minHeap.add(7)
    minHeap.remove()
    minHeap.add(15)
    minHeap.remove()
    minHeap.add(12)
    minHeap.add(9)
    minHeap.remove()
    minHeap.remove()
    println(minHeap)
}
