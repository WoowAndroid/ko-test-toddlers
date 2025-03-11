import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val A = readLine().split(" ").map { it.toInt() }.toTypedArray()
    val B = readLine().split(" ").map { it.toInt() }.toTypedArray()
    var a = 0
    var b = 0
    val answer = IntArray(N + M)
    while (a < N && b < M) {
        if (A[a] < B[b]) {
            answer[a + b] = A[a]
            a++
        } else {
            answer[a + b] = B[b]
            b++
        }
    }
    val end = a + b
    if (a != N) {
        val result = answer.toMutableList().take(end).toTypedArray() + A.toMutableList().slice(a until N)
            .toTypedArray()
        print("${result.joinToString(" ")}")
    } else if (b != M) {
        val result = answer.toMutableList().take(end).toTypedArray() + B.toMutableList().slice(b until M)
            .toTypedArray()
        print("${result.joinToString(" ")}")
    }
}
