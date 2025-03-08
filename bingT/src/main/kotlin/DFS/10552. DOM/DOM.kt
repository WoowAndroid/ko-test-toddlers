import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, P) = br.readLine().split(" ").map { it.toInt() } // 사람 수, 채널 수, 처음 나오는 채널
    val adj = IntArray(M + 1) { -1 }
    repeat(N) {
        val (end, start) = br.readLine().split(" ").map { it.toInt() } // 좋아(도착), 싫어(출발)
        if (adj[start] == -1) adj[start] = end
    }
    dfs(P, adj, 0, BooleanArray(M + 1) { false })
}

fun dfs(start: Int, adj: IntArray, cnt: Int, visited: BooleanArray) {
    if (visited[start]) { // 이미 바꾼 채널이면
        println(-1)
        return
    }
    val end = adj[start] // 해당 채널을 싫어하는 가장 어린 사람이 좋아하는 채널
    if (end == -1) {// 그 채널을 싫어하는 사람이 없으면 정답
        println(cnt)
        return
    } else {
        visited[start] = true
        dfs(end, adj, cnt + 1, visited)
    }
}
