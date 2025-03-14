import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val array = IntArray(1_000_000 + 1)
    array[0] = 0
    array[1] = 0
    array[2] = 1
    array[3] = 1
    if (N < 4) {
        println(array[N])
        return
    }
    var a = 1_000_000
    var b = 1_000_000
    var c = 1_000_000
    for (i in 4..1_000_000) {
        if (i % 3 == 0) {
            a = array[i / 3]
        }
        if (i % 2 == 0) {
            b = array[i / 2]
        }
        c = array[i - 1]
        array[i] = min(min(a, b), c) + 1
        if (i == N) break
        a = 1_000_000
        b = 1_000_000
        c = 1_000_000
    }
    println(array[N])
}