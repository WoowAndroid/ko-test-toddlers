package twopointer

import java.io.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val aArray = br.readLine().split(" ").map { it.toInt() }
    val bArray = br.readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = 0

    while (left < N && right < M) {
        if (aArray[left] < bArray[right]) {
            bw.write("${aArray[left++]} ")
        } else {
            bw.write("${bArray[right++]} ")
        }
    }

    while (left < N) bw.write("${aArray[left++]} ")
    while (right < M) bw.write("${bArray[right++]} ")

    bw.flush()
    bw.close()
}
