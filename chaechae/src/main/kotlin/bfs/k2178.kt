package bfs

import java.util.*

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val board = Array(N) { readln().map { it - '0' }.toIntArray() }

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue
            if (board[nx][ny] == 0 || board[nx][ny] != 1) continue

            board[nx][ny] = board[x][y] + 1
            queue.add(Pair(nx, ny))
        }
    }

    println(board[N-1][M-1])
}