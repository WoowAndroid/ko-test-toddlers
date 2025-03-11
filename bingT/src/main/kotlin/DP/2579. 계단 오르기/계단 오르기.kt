import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val array = IntArray(N) { readLine().toInt() }
    val answer: Array<IntArray> = Array(N) { IntArray(2) }
    answer[0] = intArrayOf(array[0], array[0])
    if (N < 2) {
        println(answer[0][0])
        return
    }
    answer[1] = intArrayOf(array[1], array[0] + array[1])
    for (i in 2 until N) {
        answer[i][0] = max(answer[i - 2][0], answer[i - 2][1]) + array[i] // 2개 전의 최댓값
        answer[i][1] = answer[i - 1][0] + array[i] // 1개 전의 가능값
    }
    println(max(answer[N - 1][0], answer[N - 1][1]))
}