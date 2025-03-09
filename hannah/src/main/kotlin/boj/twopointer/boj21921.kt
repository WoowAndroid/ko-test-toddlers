package boj.twopointer

// https://www.acmicpc.net/problem/21921
// 메모리 62104KB, 시간 456ms
fun boj21921() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val visitors = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val periods = Array(n) { 0 }

    for (i in 0..n - x) {
        // 시간 초과를 막기 위해 누적 합 활용
        periods[i] = if (i == 0) (0 until x).sumOf { visitors[it] }
        else periods[i - 1] - visitors[i - 1] + visitors[x - 1 + i]
    }

    if (periods.all { it == 0 }) bw.write("SAD")
    else {
        val max = periods.max()
        bw.write("$max\n")
        bw.write("${periods.count { it == max }}")
    }

    bw.flush()
    bw.close()
}
