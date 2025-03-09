package twopointer

fun main() {
    val (N, X) = readln().split(" ").map { it.toInt() }
    val views = readln().split(" ").map { it.toInt() }

    var sum = 0

    for (i in 0 until X) {
        sum += views[i]
    }

    var max = sum
    var maxCount = 1

    for (index in X until N) {
        sum = sum - views[index - X] + views[index]
        if (max < sum) {
            max = sum
            maxCount = 1
        } else if (max == sum) {
            maxCount++
        }
    }

    if (max == 0) println("SAD")
    else {
        println(max)
        println(maxCount)
    }
}