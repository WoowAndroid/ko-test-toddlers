package boj

import java.io.*

// https://www.acmicpc.net/problem/21918
fun boj21918() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    val orders = List(m) { br.readLine() }

    for (order in orders) {
        val (a, b, c) = order.split(" ").map { it.toInt() }
        when (a) {
            1 -> s[b - 1] = c
            2 -> {
                for (idx in b - 1..<c) {
                    if (s[idx] == 1) s[idx] = 0
                    else s[idx] = 1
                }
            }

            3 -> for (idx in b - 1..<c) s[idx] = 0
            4 -> for (idx in b - 1..<c) s[idx] = 1
        }
    }

    bw.write(s.joinToString(" "))
    bw.flush()
    bw.close()
    br.close()
}
