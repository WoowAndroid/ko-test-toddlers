fun testForStackMadeByMe() {
    val stack = Stack<Int>()

    println(stack.push(1))  // return 1, stack [1]
    println(stack.push(2))  // return 2, stack [1, 2]
    println(stack.push(4))  // return 4, stack [1, 2, 4]
    println(stack.push(2))  // return 2, stack [1, 2, 4, 2]

    println(stack.peek()) // return 2, stack [1, 2, 4, 2]
    println(stack.search(2)) // return 2
    println(stack.search(5)) // -1

    println(stack.pop()) // return 2, stack [1, 2, 4]
    println(stack.empty()) // false

    println(stack.pop()) // return 4, stack [1, 2]
    println(stack.pop()) // return 2, stack [1]
    println(stack.pop()) // return 1, stack []

    println(stack.empty()) // true
    println(stack.peek()) // EmptyStackException
}
