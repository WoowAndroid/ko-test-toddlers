import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt() // A 길이
    val A = readLine().split(" ").map { it.toInt() }.sorted().toIntArray() // A
    val M = readLine().toInt()
    val numbers: List<Pair<Int, Int>> = readLine().split(" ")
        .map { it.toInt() }
        .withIndex().map { it.value to it.index }
        .sortedBy { it.first }
    var answer = IntArray(M)
    var start = 0
    for (i in 0 until M) {
        val findIdx = find(numbers[i].first, start, A)
        val idx = numbers[i].second
        if (findIdx != -1) {
            answer[idx] = 1
            start = findIdx
        }
    }
    println(answer.joinToString("\n"))
}

fun find(target: Int, start: Int, A: IntArray): Int {
    var left = start
    var right = A.size - 1
    var idx = (left + right) / 2
    while (left <= right) { // = 필요해요
        if (target < A[idx]) {
            right = idx - 1
        } else if (A[idx] < target) {
            left = idx + 1
        } else {
            return idx
        }
        idx = (left + right) / 2
    }
    return -1
}