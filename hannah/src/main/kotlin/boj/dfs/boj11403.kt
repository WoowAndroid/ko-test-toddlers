package boj.dfs

// https://www.acmicpc.net/problem/11403
fun boj11403() {
    val n = readln().toInt()
    val graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val result = Array(n) { Array(n) { 0 } }

    fun dfs(v: Int, node: Int, visit: Array<Boolean>) {
        for (next in 0 until n) {
            // 현재 노드와 다음 수 사이에 간선이 있는지 확인
            if (graph[node][next] == 1 && !visit[next]) {
                visit[next] = true
                result[v][next] = 1 // 간선 존재 -> 정점 i에서 j로 가는 길이가 양수인 경로가 있음
                dfs(v, next, visit) // 다음 노드로 이동하여 탐색 계속
            }
        }
    }

    // 정점마다 visit 초기화 필요
    for (i in 0 until n) {
        val visit = Array(n) { false }
        dfs(i, i, visit)
    }
}