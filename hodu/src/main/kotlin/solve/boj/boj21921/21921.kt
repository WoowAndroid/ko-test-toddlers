package solve.boj.boj21921

// 백준 21921 - [실버3] 블로그
// https://www.acmicpc.net/problem/21921

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, x) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val dailyVisitor = br.readLine()?.split(" ")?.map{it.toInt()} ?: return

    var maxVisitor = 0
    var xCounts = 1
    var from = 0
    var to = x - 1
    var totalXVisitor = dailyVisitor.slice(0..to).sumOf { it }
    while(to < n) {
        if (maxVisitor == totalXVisitor) xCounts++
        else if (maxVisitor < totalXVisitor) {
            maxVisitor = totalXVisitor
            xCounts = 1
        }
        if (to + 1 >= n) break
        totalXVisitor += dailyVisitor[++to] - dailyVisitor[from++]
    }
    val bw = System.out.bufferedWriter()
    if(maxVisitor == 0) bw.write("SAD")
    else bw.write("${maxVisitor}\n$xCounts")
    bw.close()
}