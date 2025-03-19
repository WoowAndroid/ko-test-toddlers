package solve.boj.boj2579

import kotlin.math.max

// 백준 2579 - [실버3] 계단 오르기
// https://www.acmicpc.net/problem/2579

/* 아래 풀이에 대한 반례
input:
10
10
10
10
100
100
100
10
100
10

output:
420

answer:
430
*/

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine()?.toInt() ?: 0
    val stairs = Array(n){0}
    repeat(n) { stairs[it] = br.readLine()?.toInt() ?: 0 }
    if (n == 1) {
        bw.write("${stairs[0]}")
        bw.close()
        return
    }

    // 누적 최대 점수 to 연속된 계단을 밟은 횟수, 꼭대기에서 아래로
    val scores = Array(n){ 0 to 1 }
    // 3번 규칙을 지키기 위해 마지막 계단에서부터 시작
    scores[n-1] = stairs[n-1] to 1
    scores[n-2] = stairs[n-1] + stairs[n-2] to 2
    var step = n - 3
    while(step >= 0) { scores.dp(step--, stairs) }
    println(scores.contentToString())
    val maxScore = max(scores[0].first, scores[1].first)
    bw.write("$maxScore")
    bw.close()
}

private fun Array<Pair<Int, Int>>.dp(step: Int, stairs: Array<Int>) {
    println("step: $step")
    var score = this[step+2].first + stairs[step]
    var continuous = 1
    if (this[step+1].second < 2 && score < (this[step+1].first + stairs[step])) {
        score = this[step+1].first + stairs[step]
        continuous = this[step+1].second + 1
    }
    this[step] = score to continuous
    println("점수: ${this[step]}")
}
