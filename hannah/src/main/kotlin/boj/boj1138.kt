package boj

// https://www.acmicpc.net/problem/1138
fun boj1138() {
    val n = readln().toInt()
    val data = readln().split(" ").map { it.toInt() }
    val answer = Array(n) { 0 }

    for (i in 0 ..< n) {
        var count = 0

        for (j in 0 ..< n) {
            if (count == data[i] && answer[j] == 0) {
                answer[j] = i + 1
                break
            } else if (answer[j] == 0) count++
        }
    }
    println(answer.joinToString(" "))
}
