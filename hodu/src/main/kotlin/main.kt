import datastructure.Stack
import datastructure.StackUsingTop

fun main() {
    println("hello walnut")
    testStack()
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
