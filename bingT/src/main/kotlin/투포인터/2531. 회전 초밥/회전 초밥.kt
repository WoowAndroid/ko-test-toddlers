import java.io.BufferedReader
import java.io.InputStreamReader
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 가장 다양한 가짓수의 경우 중 c를 포함하지 않는 것이 있다면 +1
    val (N, _, k, c) = readLine().split(" ").map { it.toInt() }
    val sushi = IntArray(N)
    repeat(N) {
        sushi[it] = readLine().toInt()
    }
    val dish = mutableListOf(c)
    for (i in 0 until k) {
        dish.add(sushi[i])
    }
    var max = dish.toSet().size
    var start = 0
    while (start < N) {
        var end = start + k
        dish.add(sushi[end % N])
        dish.remove(sushi[start])
        if (max < dish.toSet().size) max = dish.toSet().size
        start++
    }
    println(max)
}
