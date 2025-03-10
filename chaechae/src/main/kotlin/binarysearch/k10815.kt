package binarysearch

fun main() {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.sorted()
    val M = readln().toInt()
    val Mlist = readln().split(" ").map { it.toInt() }

    Mlist.forEach {
        cardBinarySearch(numbers, it)
    }

}

fun cardBinarySearch(numbers: List<Int>, target: Int) {
    var left = 0
    var right = numbers.size - 1

    while (left <= right) {
        val mid = (left + right) / 2
        if (numbers[mid] < target) {
            left = mid + 1
        } else if (numbers[mid] == target) {
            print("1 ")
            return
        } else {
            right = mid - 1
        }
    }

    print("0 ")
    return
}
