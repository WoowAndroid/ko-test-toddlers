package solve.boj.boj10815

// 백준 10815 - [실버5] 숫자 카드 : 이분 탐색
// https://www.acmicpc.net/problem/10815

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine()?.toInt() ?: 0
    val cards = br.readLine()?.split(" ")?.map{it.toInt()}?.toIntArray()?.apply{sort()} ?: return
    val m = br.readLine()?.toInt() ?: 0
    val others = br.readLine()?.split(" ")?.map{it.toInt()} ?: return

    val result = Array(m) {0}
    repeat(m) {
        result[it] = cards.binarySearch(others[it])
    }
    result.forEach { bw.write("$it ") }
    bw.close()
}

private fun IntArray.binarySearch(target: Int): Int {
    var from = 0
    var to = this.size - 1
    while(from <= to) {
        val middle = (from+to)/2
        if (this[middle] == target) return 1
        else if (this[middle] > target) to = middle - 1
        else from = middle + 1
    }
    return 0
}