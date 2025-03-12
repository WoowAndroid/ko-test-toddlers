package solve.boj.boj1920

// 백준 1920 - [실버4] 수 찾기 : 이분 탐색
// https://www.acmicpc.net/problem/1920

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine()?.toInt() ?: 0
    val aArray = br.readLine()?.split(" ")?.map{it.toInt()}?.toIntArray() ?: return
    aArray.sort()
    val m = br.readLine()?.toInt() ?: 0
    val mArray = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val result = Array(m) {0}
    repeat(m) {
        result[it] = aArray.binarySearch(mArray[it])
    }
    result.forEach { bw.write("$it\n") }
    bw.close()
}

private fun IntArray.binarySearch(target: Int): Int {
    var from = 0
    var to = this.size - 1
    while (from <= to) {
        val middle = (from + to)/2
        if(this[middle] == target) return 1
        else if(this[middle] > target) to = middle - 1
        else from = middle + 1
    }
    return 0
}
