import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val array: Array<IntArray> = Array(N) { br.readLine().map { it.digitToInt() }.toIntArray() }
    val queue: Queue<IntArray> = LinkedList()
    queue.add(intArrayOf(0, 0))

    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, 1, -1)

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll() // 큐에서 뽑아와
        if (y == N - 1 && x == M - 1) { // 종점 도착
            println(array[y][x])
            break
        }
        for (i in 0..3) {
            val newY = y + dy[i]
            val newX = x + dx[i]
            if ((newY in 0 until N && newX in 0 until M).not()) continue
            if (array[newY][newX] == 1) {
                array[newY][newX] = array[y][x] + 1
                queue.add(intArrayOf(newY, newX))
            }
        }
    }
}
