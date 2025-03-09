import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, V) = readLine().split(" ").map { it.toInt() } // 정점, 간선, 시작점
    val list = Array(N) { mutableListOf<Int>() }
    repeat(M) {
        val (start, end) = readLine().split(" ").map { it.toInt() - 1 }
        list[start].add(end)
        list[end].add(start)
    }
    for (idx in 0 until N) {
        list[idx] = list[idx].sorted().toMutableList()
    }
    dfs(V - 1, list, BooleanArray(N) { false })
    println()
    bfs(V - 1, list, BooleanArray(N) { false })
}

fun dfs(start: Int, list: Array<MutableList<Int>>, visited: BooleanArray) {
    print("${start + 1} ")
    visited[start] = true
    for (i in list[start]) {
        if (!visited[i] && list[i].isNotEmpty()) dfs(i, list, visited)
    }
}

fun bfs(start: Int, list: Array<MutableList<Int>>, visited: BooleanArray) {
    visited[start] = true
    val queue = LinkedList<Int>()
    queue.add(start)
    while (queue.isNotEmpty()) {
        val vertex = queue.poll()
        print("${vertex + 1} ")
        for (target in list[vertex]) {
            if (!visited[target]) {
                visited[target] = true
                queue.add(target)
            }
        }
    }
}