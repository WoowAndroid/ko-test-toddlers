package solve.boj

class Boj9093Solution {
    private val testCases: List<String> =
        listOf(
            "I am happy today",
            "We want to win the first prize",
        )
    private val answers: List<String> =
        listOf(
            "I ma yppah yadot",
            "eW tnaw ot niw eht tsrif ezirp",
        )

    fun solve() {
        val T = readln().toInt()
        repeat(T) {
            val input = readln()
            solution(input)
        }
    }

    fun solution(input: String) {
        val stack: ArrayDeque<Char> = ArrayDeque()
        val words = input.split(" ").map { word ->
            val stringBuilder = StringBuilder()
            word.forEach { stack.addFirst(it) }
            repeat(stack.size) { stringBuilder.append(stack.removeFirst()) }
            stringBuilder.toString()
        }
        println(words.joinToString(" "))
    }

    fun runTestCases() {
        testCases.forEachIndexed { index, testCase ->
            println("[test $index]")
            println("case: $testCase")
            print("result: ")
            solution(testCase)
            println("actual: ${answers[index]}")
            println()
        }
    }
}
