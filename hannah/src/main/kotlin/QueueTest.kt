import java.util.LinkedList

fun testForQueueMadeByMe() {
    val queue = Queue<Int>(capacity = 4)

    println(queue.add(1)) // true
    println(queue.add(2)) // true
    println(queue.offer(3)) // true
    println(queue.offer(4)) // true

    println(queue.offer(5)) // false
    println(queue.add(6)) // IllegalStateException

    println(queue.remove()) // return 1
    println(queue.poll()) // return 2

    println(queue.element()) // return 3
    println(queue.peek()) // return 3

    println(queue.remove()) // return 3
    println(queue.poll()) // return 4

    println(queue.poll()) // null
    println(queue.remove()) // NoSuchElementException

    println(queue.peek()) // null
    println(queue.element()) // NoSuchElementException
}

fun testForQueueByJava() {
    val queue: java.util.Queue<Int> = LinkedList()

    println(queue.add(1)) // true
    println(queue.add(2)) // true
    println(queue.offer(3)) // true
    println(queue.offer(4)) // true

    println(queue.remove()) // return 1
    println(queue.poll()) // return 2

    println(queue.element()) // return 3
    println(queue.peek()) // return 3

    println(queue.remove()) // return 3
    println(queue.poll()) // return 4

    // println(queue.poll()) // NullPointerException: poll(...) must not be null
    // println(queue.remove()) // NoSuchElementException

    // println(queue.peek()) // NullPointerException: peek(...) must not be null
    println(queue.element()) // NoSuchElementException
}
