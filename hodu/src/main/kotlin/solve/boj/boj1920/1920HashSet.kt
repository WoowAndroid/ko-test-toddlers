package solve.boj.boj1920

// 백준 1920 - [실버4] 수 찾기 : HashSet 활용
// https://www.acmicpc.net/problem/1920

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine()?.toInt() ?: 0
    val set = br.readLine()?.split(" ")?.map{it.toInt()}?.toHashSet() ?: return
    val m = br.readLine()?.toInt() ?: 0
    val mArray = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val result = Array(m) {0}
    repeat(m) {
        result[it] = if (set.contains(mArray[it])) 1 else 0
    }
    result.forEach { bw.write("$it\n") }
    bw.close()
}
