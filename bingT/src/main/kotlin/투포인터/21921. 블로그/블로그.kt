import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 블로그를 시작하고 지난 일수가 N일 때 -> 검색 갯수
    // X일 동안 가장 많이 들어온 방문자 수를 구해라 -> window size
    val (N, X) = readLine().split(" ").map { it.toInt() }
    val visiters = readLine().split(" ").map { it.toInt() }.toTypedArray()
    var sum = visiters.toList().take(X).sum() // sum메서드
    var max = sum
    var cnt = 1
    var p = 1
    while (p < N - X + 1) {
        sum = sum - visiters[p - 1] + visiters[p + X - 1]
        if (max < sum) {
            cnt = 1
            max = sum
        } else if (max == sum) cnt++
        p++
    }
    if (max == 0) println("SAD")
    else print("$max\n$cnt")
}
