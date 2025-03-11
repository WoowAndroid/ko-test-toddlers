package binarysearch

fun main() {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val M = readln().toInt()
    val Marray = readln().split(" ").map { it.toInt() }

    Marray.forEach {
        println(numberBinarySearch(numbers, it, N))
    }
}

fun numberBinarySearch(numbers: List<Int>, target: Int, N: Int): Int {
    var left = 0
    var right = N - 1

    while (left <= right) {
        val mid = (left + right) / 2
        // println("$left, $mid, $right")
        if (numbers[mid] < target) {
            left = mid + 1
        } else if (numbers[mid] == target) {
            return 1
        } else {
            right = mid - 1
        }
    }

    return 0
}
