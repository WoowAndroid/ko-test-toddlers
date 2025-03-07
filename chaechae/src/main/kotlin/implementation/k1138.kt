package implementation

fun main() {
    val N = readln().toInt()
    val heightList = readln().split(" ").map { it.toInt() }
    val result = IntArray(N)

    for (h in heightList.indices) {
        calculate(result, h+1, heightList[h])
    }

    println(result.joinToString(" "))
}

fun calculate(result: IntArray, height: Int, x: Int) {
    var count = 0
    for (i in result.indices) {
        if (count == x) {
            for (j in i until result.size) {
                if (result[j] == 0) {
                    result[j] = height
                    break
                }
            }
            break
        } else if (result[i] == 0) {
            count++
        }
    }
}