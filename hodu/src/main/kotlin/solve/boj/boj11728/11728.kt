package solve.boj.boj11728

// 백준 11728 - [실버5] 배열 합치기
// https://www.acmicpc.net/problem/11728

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val aArray = br.readLine()?.split(" ")?.map{it.toInt()}?.toIntArray() ?: return
    val bArray = br.readLine()?.split(" ")?.map{it.toInt()}?.toIntArray() ?: return

    val total = IntArray(n+m)
    var ap = 0
    var bp = 0
    while(ap < n && bp < m) {
        if(aArray[ap] <= bArray[bp]) {
            total[ap + bp] = aArray[ap]
            ap++
        } else {
            total[ap + bp] = bArray[bp]
            bp++
        }
    }
    while(ap < n) {
        total[ap + bp] = aArray[ap]
        ap++
    }
    while(bp < m) {
        total[ap + bp] = bArray[bp]
        bp++
    }

    val bw = System.out.bufferedWriter()
    bw.write(total.joinToString(" "))
    bw.close()
}