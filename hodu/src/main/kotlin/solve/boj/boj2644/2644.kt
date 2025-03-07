package solve.boj.boj2644

// 백준 2644 - [실버2] 촌수 계산
// https://www.acmicpc.net/problem/2644

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()?.toInt() ?: return
    val (first, second) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val m = br.readLine()?.toInt() ?: return

    val relation: MutableList<MutableList<Int>> = MutableList(n+1) {mutableListOf()}
    repeat(m) {
        val ln = br.readLine() ?: return
        val (x, y) = ln.split(" ").map{it.toInt()}
        relation[x].add(y)
        relation[y].add(x)
    }

    val answer = bfs(first, second, relation)
    println(answer)
}

fun bfs(start: Int, dest: Int, relation: MutableList<MutableList<Int>>): Int {
    val visited: Array<Boolean> = Array(relation.size) {false}
    val queue: MutableList<Int> = mutableListOf()
    val counts = MutableList<Int>(relation.size) {-1}
    visited[start] = true
    queue.add(start)
    while(queue.isNotEmpty()) {
        val node = queue.removeFirst()
        visited[node] = true
        counts[node] = counts[node] + 1
        if (node == dest) return counts[node]
        for(child in relation[node]) {
            if(!visited[child]) {
                queue.add(child)
                counts[child] = counts[node]
            }
        }
    }
    return counts[dest]
}