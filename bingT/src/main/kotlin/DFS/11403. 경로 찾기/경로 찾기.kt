import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt() // 수
    val array: Array<IntArray> = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var visited = BooleanArray(N) { false }
    val queue = LinkedList<Int>()
    for (i in 0 until N) { // i번째 줄 검사
        queue.add(i)
        val answer = array[i]
        while (queue.isNotEmpty()) {
            val newI = queue.poll()
            for (j in 0 until N) {
                if (array[newI][j] == 1 && !visited[j]) {
                    visited[j] = true
                    answer[j] = 1
                    queue.add(j)
                }
            }
        }
        visited = BooleanArray(N) { false }
        println(answer.joinToString(" "))
    }
}
