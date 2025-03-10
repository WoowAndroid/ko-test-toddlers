package solve.boj.boj10552

// 백준 10552 - [실버2] DOM
// https://www.acmicpc.net/problem/10552

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, p) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val hateMap = mutableMapOf<Int, MutableList<Int>>()  // key: channel, value: hater list
    val likeList = Array<Int>(n){0}
    repeat(n) {
        val (a, b) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
        likeList[it] = a
        val key = hateMap[b]
        if (key == null) {
            hateMap[b] = mutableListOf(it)
        } else {
            key.add(it)
        }
    }

    val bw = System.out.bufferedWriter()
    val changed = Array<Boolean>(n){false}
    val answer = dfs(p, hateMap, likeList, changed)
    bw.write(answer.toString())
    bw.close()
}

fun dfs(channel: Int, hateMap: Map<Int, List<Int>>, likeList: Array<Int>, changed: Array<Boolean>): Int {
    val haters = hateMap[channel] ?: return 0
    val youngest = haters.first()
    if(changed[youngest]) return -1
    changed[youngest] = true
    val next = dfs(likeList[youngest], hateMap, likeList, changed)
    return if(next == -1) -1
    else next + 1
}
