package deque

fun testForDequeMadeByMe() {
    val deque = Deque<Int>()

    deque.addFirst(1) // deque [1]
    deque.offerLast(2) // deque [1, 2]
    deque.addLast(3) // deque [1, 2, 3]
    deque.offerFirst(4) // deque [4, 1, 2, 3]

    println(deque.getFirst()) // 4
    println(deque.getLast()) // 3
    println(deque.peekFirst()) // 4
    println(deque.peekLast()) // 3

    deque.removeFirst() // [1, 2, 3]
    deque.removeLast() // [1, 2]
    deque.pollFirst() // [2]
    deque.pollLast() // []

    println(deque.pollFirst()) // null
    println(deque.pollLast()) // null
    println(deque.peekFirst()) // null
    println(deque.peekLast()) // null

    deque.removeFirst() // NoSuchElementException
    deque.removeLast() // NoSuchElementException
    deque.getFirst() // NoSuchElementException
    deque.getLast() // NoSuchElementException
}
