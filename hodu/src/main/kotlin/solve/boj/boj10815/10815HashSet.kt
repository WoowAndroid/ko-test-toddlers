package solve.boj.boj10815

// 백준 10815 - [실버5] 숫자 카드 : HashSet
// https://www.acmicpc.net/problem/10815

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine()?.toInt() ?: 0
    val cards = br.readLine()?.split(" ")?.map{it.toInt()}?.toHashSet() ?: return
    val m = br.readLine()?.toInt() ?: 0
    val others = br.readLine()?.split(" ")?.map{it.toInt()} ?: return

    val result = Array(m) {0}
    repeat(m) { result[it] = if (cards.contains(others[it])) 1 else 0 }
    result.forEach { bw.write("$it ") }
    bw.close()
}
