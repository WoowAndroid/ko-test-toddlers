import datastructure.Queue
import datastructure.QueueWithIndex
import datastructure.Stack
import datastructure.StackUsingTop

fun main() {
    println("hello walnut")
//    testStack()
    testQueue()
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
