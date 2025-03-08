import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M, K) = br.readLine().split(" ").map { it.toInt() } // 세로, 가로, 음쓰 개수
    val array = Array(N) { IntArray(M) { 0 } } // 인접행렬
    val adjacency = LinkedList<IntArray>() // 인접리스트
    val queue = LinkedList<IntArray>()
    repeat(K) {
        val (Y, X) = br.readLine().split(" ").map { it.toInt() }
        array[Y-1][X-1] = 1
        adjacency.add(intArrayOf(Y-1, X-1))
    }
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    var max = 0
    while (adjacency.isNotEmpty()) { // 인접리스트가 비어있지 않을 떄
        val (m, n) = adjacency.poll()
        queue.add(intArrayOf(m, n))
        array[m][n] = 0
        var cnt = 1
        while (queue.isNotEmpty()) {
            val (y, x) = queue.poll()
            for (i in 0..3) {
                val newY = y + dy[i]
                val newX = x + dx[i]
                if (!(newX in 0..M - 1 && newY in 0..N - 1)) continue
                if (array[newY][newX] == 1) {
                    queue.add(intArrayOf(newY, newX))
                    adjacency.remove(intArrayOf(newY, newX))
                    array[newY][newX] = 0
                    cnt++
                }
            }
        }
        max = max(cnt,max)
        cnt = 1
    }
    println(max)
}
