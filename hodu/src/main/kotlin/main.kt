import datastructure.*

fun main() {
    println("hello walnut")
//    testStack()
//    testQueue()
    testMinHeap()
    testMaxHeap()
}

private fun testStack() {
    val stack: Stack<Int> = StackUsingTop(3)
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(3)

    println(stack.peek())

    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}

private fun testQueue() {
    val queue: Queue<Int> = QueueWithIndex(4)
    queue.enqueue(5)
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")
    queue.enqueue(6)
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")
    queue.enqueue(7)
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")
    queue.enqueue(8)
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")
    queue.enqueue(9)
    println("peeked data: ${queue.peek()}")

    println("dequeue: ${queue.dequeue()}")
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")

    println("dequeue: ${queue.dequeue()}")
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")

    println("dequeue: ${queue.dequeue()}")
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")

    println("dequeue: ${queue.dequeue()}")
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")

    println("dequeue: ${queue.dequeue()}")
    println("size: ${queue.size}, front: ${queue.front}, rear: ${queue.rear}")

}

private fun testMinHeap() {
    val minHeap: MinHeap = MinHeap(10)
    println("--- [최소 힙 테스트] ---")
    println("delete: ${minHeap.delete()}")
    println(minHeap.isEmpty())

    minHeap.insert(3)
    minHeap.insert(5)
    minHeap.insert(10)
    minHeap.insert(2)
    minHeap.insert(9)
    println("마지막 노드 번호: ${minHeap.endNodeIndex}")
    for (i in 1..minHeap.size) {
        print("$i[${minHeap.heap[i]}]  ")
    }
    println()

    minHeap.insert(15)
    minHeap.insert(2)
    minHeap.insert(-3)
    minHeap.insert(-6)
    minHeap.insert(0)
    minHeap.insert(100)
    println("마지막 노드 번호: ${minHeap.endNodeIndex}")
    for (i in 1..minHeap.size) {
        print("$i[${minHeap.heap[i]}]  ")
    }
    println()

    println("delete: ${minHeap.delete()}")
    println("delete: ${minHeap.delete()}")
    println("delete: ${minHeap.delete()}")
    println("마지막 노드 번호: ${minHeap.endNodeIndex}")
    for (i in 1..minHeap.size) {
        print("$i[${minHeap.heap[i]}]  ")
    }
    println()
}

private fun testMaxHeap() {
    val maxHeap: MaxHeap = MaxHeap(10)
    println("--- [최대 힙 테스트] ---")
    println("delete: ${maxHeap.delete()}")
    println(maxHeap.isEmpty())

    maxHeap.insert(3)
    maxHeap.insert(5)
    maxHeap.insert(10)
    maxHeap.insert(2)
    maxHeap.insert(9)
    println("마지막 노드 번호: ${maxHeap.endNodeIndex}")
    for (i in 1..maxHeap.size) {
        print("$i[${maxHeap.heap[i]}]  ")
    }
    println()

    maxHeap.insert(15)
    maxHeap.insert(2)
    maxHeap.insert(-3)
    maxHeap.insert(-6)
    maxHeap.insert(0)
    maxHeap.insert(100)
    println("마지막 노드 번호: ${maxHeap.endNodeIndex}")
    for (i in 1..maxHeap.size) {
        print("$i[${maxHeap.heap[i]}]  ")
    }
    println()

    println("delete: ${maxHeap.delete()}")
    println("delete: ${maxHeap.delete()}")
    println("delete: ${maxHeap.delete()}")
    println("마지막 노드 번호: ${maxHeap.endNodeIndex}")
    for (i in 1..maxHeap.size) {
        print("$i[${maxHeap.heap[i]}]  ")
    }
    println()
}
