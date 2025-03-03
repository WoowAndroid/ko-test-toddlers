package solve.programmers

class ProcessSolution {
    private val testCases: List<Pair<IntArray, Int>> =
        listOf(
            intArrayOf(2, 1, 3, 2) to 2,
            intArrayOf(1, 1, 9, 1, 1, 1) to 0,
            intArrayOf(2, 1, 3, 2, 3, 9, 3) to 6,
            intArrayOf(1, 1, 1, 1, 1, 2) to 4,
            intArrayOf(1, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0) to 9,
        )

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val deque: ArrayDeque<Pair<Int, Int>> =
            ArrayDeque(
                priorities.mapIndexed { index, priority ->
                    index to priority
                }
            )

        while (!deque.isEmpty()) {
            val process = deque.removeFirst()
            if (deque.any {process.second < it.second}) {
                deque.addLast(process)
            } else {
                answer++
                if (process.first == location) break
            }
        }

        return answer
    }

    fun runTestCases() {
        testCases.forEachIndexed { index, testCase ->
            println("[test $index]")
            val answer = solution(testCase.first, testCase.second)
            println("case: ${testCase.first.contentToString()}, ${testCase.second} , answer: $answer")
            println()
        }
    }
}

//fun IntArray.toString(): String {
//    val sb = StringBuilder()
//    return sb.append('[', joinToString(", "), ']').toString()
//}
