import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val sortedNumbers = IntArray(N)
    var candidates : IntArray = (0..N-1).toList().toIntArray()
    for (i in 0..N-1) {
        val tallerNumber = numbers[i] // 왼쪽으로 나보다 키 큰 사람 수
        val height = i + 1 // 나의 키
        val newPosition = candidates[tallerNumber] // 내가 있어야 할 자리
        sortedNumbers[newPosition] = height
        val tmp = candidates.toMutableList()
        tmp.remove(newPosition)
        candidates = tmp.toIntArray()
    }
    println(sortedNumbers.joinToString(" "))
}
