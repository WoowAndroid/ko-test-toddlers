package solve.boj.boj11403

// (1, 2) : 1에서 2로 가는 간선 존재
// (2, 3) : 2에서 3으로 가는 간선 존재
// (3, 1) : 3에서 1로 가는 간선 존재

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()?.toInt() ?: 0
    val graph = Array(n) { IntArray(n) }
    repeat(n) {
        val row = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
        graph[it] = row.toIntArray()
    }

    val answer: Array<IntArray> = graph.copyOf()
    for(i in 0 ..< n) {
        for (j in 0 ..< n) {
            val visited = Array(n) { false }
            dfs(i, i, j, graph, answer, visited)
        }
    }

    val bw = System.out.bufferedWriter()
    for (row in answer) {
        bw.write(row.joinToString(" ") + "\n")
    }
    bw.flush()
    bw.close()
}

fun dfs(
    node: Int,
    start: Int,
    dest: Int,
    graph: Array<IntArray>,
    answer: Array<IntArray>,
    visited: Array<Boolean>,
) {
    // node: 현재 방문한 노드, start로부터 출발해 방문 가능한 노드임
    if(visited[node]) return  // 이미 방문했다면 종료
    visited[node] = true  // 방문 처리
    // node가 dest와 연결되어있다면, start와도 연결되어 있음
    if (graph[node][dest] == 1) {
        answer[start][dest] = 1
        return
    }
    // node에서 방문 가능한 다음 노드를 찾아서 dfs
    for(next in graph.indices) {
        if (graph[node][next] == 1) dfs(next, start, dest, graph, answer, visited)
    }
}
