package bfs

import java.util.*

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }
    val board = Array(N) { IntArray(M) { 0 } }
    val visited = Array(N) { BooleanArray(M) }

    repeat(K) {
        val (x, y) = readln().split(" ").map { it.toInt() - 1 }
        board[x][y] = 1
    }

    var maxFood = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (board[i][j] == 1 && !visited[i][j]) {
                maxFood = maxOf(maxFood, foodBfs(i, j, board, visited, N, M))
            }
        }
    }

    println(maxFood)
}

fun foodBfs(x: Int, y: Int, board: Array<IntArray>, visited: Array<BooleanArray>, N: Int, M: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(x to y)
    visited[x][y] = true

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    var size = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue
            if (visited[nx][ny] || board[nx][ny] == 0) continue

            board[nx][ny] = board[x][y] + 1
            queue.add(nx to ny)
            visited[nx][ny] = true
            size++
        }
    }

    return size
}