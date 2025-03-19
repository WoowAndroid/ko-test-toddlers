package solve.boj.boj2579

import kotlin.math.max

// 백준 2579 - [실버3] 계단 오르기
// https://www.acmicpc.net/problem/2579

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine()?.toInt() ?: 0
    val stairs = Array(n+1){0}
    repeat(n) { stairs[it+1] = br.readLine()?.toInt() ?: 0 }
    if (n == 1) {
        bw.write("${stairs[1]}")
        bw.close()
        return
    }

    // scores[x][0] = 직전 칸에서 뜀
    // scores[x][1] = 전전 칸에서 뜀 -> 전전 칸에서의 두 경우(1칸 뛰었을 때([0])와 2칸 뛰었을 때([1])) 중 최대 점수를 찾아 설정
    val scores = Array(n + 1){ arrayOf(0, 0) }
    scores[1] = arrayOf(stairs[1], stairs[1])
    for (step in 2..n) { scores.dp(step, stairs) }
    val maxScore = max(scores[n][0], scores[n][1])
    bw.write("$maxScore")
    bw.close()
}

private fun Array<Array<Int>>.dp(step: Int, stairs: Array<Int>) {
    this[step][0] = this[step - 1][1] + stairs[step]
    this[step][1] = max(this[step - 2][0], this[step - 2][1]) + stairs[step]
}
