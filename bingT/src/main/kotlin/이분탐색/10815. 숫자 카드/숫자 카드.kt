import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
    val N = readLine().toInt()
    // 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
    val numbers = readLine().split(" ").map { it.toInt() }.sorted().toTypedArray()
    val M = readLine().toInt()
    val cards: Map<Int, Int> =
        readLine().split(" ").map { it.toInt() }.withIndex().associate { it.value to it.index }.toSortedMap()
    val answers = IntArray(M)
    var start = 0
    for (card in cards) {
        val nextStart = find(card.key, start, numbers)
        if (nextStart == -1) {
            answers[card.value] = 0
        } else {
            answers[card.value] = 1
            start = nextStart
        }
    }
    println("${answers.joinToString(" ")}")
}

fun find(card: Int, start: Int, numbers: Array<Int>): Int {
    var start = start
    var end = numbers.size - 1
    var idx = 0
    while (start <= end) {
        idx = (start + end) / 2
        if (card < numbers[idx]) {
            end = idx - 1
        } else if (numbers[idx] < card) {
            start = idx + 1
        } else {
            return idx + 1
        }
    }
    return -1
}
