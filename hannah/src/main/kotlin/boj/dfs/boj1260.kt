package boj.dfs

import java.util.*

fun boj1260() {
    // 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있음
    // 입력으로 주어지는 간선은 양방향
    val (n, m, v) = readln().split(" ").map { it.toInt() }

    // 인접 행렬, 인접 리스트로 구현 가능
    // 정점 번호는 1번부터 N번이기 때문에 n + 1로 계산해 index 값을 별도로 계산 하지 않아도 되도록 함
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b) // 입력으로 주어지는 간선은 양방향
        graph[b].add(a)
    }

    // 방문할 수 있는 정점이 여러 개인 경우 -> 정점 번호가 작은 것을 먼저 방문
    graph.map { it.sort() }

    dfs(v, graph)
    bfs(v, graph)
}

// dfs: 스택이나 재귀를 활용해 풀이 가능
fun dfs(start: Int, graph: Array<MutableList<Int>>) {
    // 각 정점이 "한 번 방문했는지 여부"만 알면 되기 때문에 방문 여부는 1차원 배열 사용
    val visit = Array(graph.size) { false }
    val stack = Stack<Int>()
    val result = mutableListOf<Int>()

    stack.push(start)

    while (stack.isNotEmpty()) {
        val v = stack.pop()

        // 중복 방문을 방지 하기 위해 pop하는 순간 방문 여부를 체크하고 즉시 처리
        if (!visit[v]) {
            visit[v] = true
            result.add(v)

            // reversed 이유: 스택은 LIFO이기 때문, 정점 번호가 작은 것을 먼저 방문하기 위해서는 스택에 큰 수부터 넣어야 함
            for (nextV in graph[v].reversed()) {
                if (!visit[nextV]) {
                    stack.push(nextV)
                }
            }
        }
    }

    println(result.joinToString(" "))
}

// bfs: 큐를 활용해 풀이 가능
fun bfs(start: Int, graph: Array<MutableList<Int>>) {
    val visit = Array(graph.size) { false }
    val queue: Queue<Int> = ArrayDeque()
    val result = mutableListOf<Int>()

    // 중복 방문을 막기 위해 큐에 넣을 때 즉시 방문 처리
    queue.add(start)
    visit[start] = true

    while (queue.isNotEmpty()) {
        val v = queue.poll()
        result.add(v)

        for (nextV in graph[v]) {
            if (!visit[nextV]) {
                queue.add(nextV)
                visit[nextV] = true
            }
        }
    }

    println(result.joinToString(" "))
}
