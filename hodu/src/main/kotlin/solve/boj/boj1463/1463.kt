package solve.boj.boj1463

// 백준 1463 - [실버3] 1로 만들기
// https://www.acmicpc.net/problem/1463

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine()?.toInt() ?: 0
    val dp = Array(n + 1) { 0 }
    for (i in 1..n) {
        dp.compute(i)
    }
    bw.write("${dp[n]}\n")
    bw.close()
}

private fun Array<Int>.compute(x: Int) {
    if (x == 1) return
    var min = this[x-1] + 1
    if (x % 3 == 0) min = min(this[x/3] + 1, min)
    if (x % 2 == 0) min = min(this[x/2] + 1, min)
    this[x] = min
}

// 계산 횟수의 최솟값
/*
1. 2로 나눌 수 있으면 나누기 2 -> x/2
2. 3으로 나눌 수 있으면 나누기 3 -> x/3
3. 빼기 1 -> x-1

 1 2 3 4 5 6 7 8 9 10
[0,1,1,2,3,2,3,3,2,3]

*/
