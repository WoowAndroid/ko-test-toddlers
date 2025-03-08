package dfs

fun main() {
    val N = readln().toInt()
    val matrix = Array(N) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val result = Array(N) { IntArray(N) { 0 } }

    fun dfs(start: Int, node: Int, visited: BooleanArray) {
        // 현재 노드(node)와 연결된 모든 next 노드를 검사
        for (next in 0 until N) {
            // matrix의 next부분이 1이고, 방문하지 않았을 경우
            if (matrix[node][next] == 1 && !visited[next]) {
                visited[next] = true
                result[start][next] = 1
                // 현재 node에서 갈 수 있는 next 정점을 찾았으니, next를 새로운 node로 탐색을 계속 진행
                dfs(start, next, visited)
            }
        }
    }

    for (i in 0 until N) {
        // 각 정점마다 독립적인 DFS 탐색
        val visited = BooleanArray(N) { false }
        dfs(i, i, visited)
    }

    result.forEach { println(it.joinToString(" ")) }
}