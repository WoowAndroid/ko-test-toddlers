package dfs

import java.util.*

fun main() {
    val (N, M, V) = readln().split(" ").map { it.toInt() }
    val graph = Array(N) { mutableListOf<Int>() }

    repeat(M) {
        val (x, y) = readln().split(" ").map { it.toInt() - 1 }
        graph[x].add(y)
        graph[y].add(x)
    }

    // 정점 연결 작은 순으로 정렬
    graph.forEach { it.sort() }

    fun dfs(start: Int, node: Int, visited: MutableSet<Int>) {
        print("${node + 1} ")

        for (next in graph[node]) {
            if (next !in visited) {
                visited.add(next)
                dfs(start, next, visited)
            }
        }
    }

    val visited = mutableSetOf<Int>()
    visited.add(V - 1)
    dfs(V - 1, V - 1, visited)
    println()


    fun bfs(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)

        val visited = mutableSetOf<Int>()
        visited.add(start)
        print("${start + 1} ")

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            for (next in graph[current]) {
                if (next !in visited) {
                    print("${next + 1} ")
                    queue.add(next)
                    visited.add(next)
                }
            }
        }
    }

    bfs(V - 1)
}