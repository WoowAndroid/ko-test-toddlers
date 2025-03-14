import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (T, W) = readLine().split(" ").map { it.toInt() }
    val jadu = IntArray(T) { readLine().toInt() }
    val array = Array(T) { IntArray(W+1) }
    for(w in 0 .. W) if (w % 2 + 1 == jadu[0]) array[0][w]++
    for (t in 1 until T) {
        array[t][0] = array[t-1][0]
        if (1 == jadu[t]) array[t][0]++
        for (w in 1 .. W) {
            array[t][w] = max(array[t-1][w-1],array[t-1][w])
            if (w % 2 + 1 == jadu[t]) array[t][w]++
        }
    }
    println(array[T-1].max())
}