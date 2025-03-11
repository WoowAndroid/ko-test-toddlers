package boj.binaryserach

fun boj10815() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }

    val m = br.readLine().toInt()
    val numbers = br.readLine().split(" ").mapIndexed { index, s -> index to s.toInt() }.sortedBy { it.second }

    val result = Array(m) { 0 }

    repeat(n) {
        var start = 0
        var end = m - 1

        while (start <= end) {
            val mid = (start + end) / 2

            when {
                cards[it] == numbers[mid].second -> {
                    result[numbers[mid].first] = 1
                    break
                }

                cards[it] < numbers[mid].second -> end = mid - 1
                cards[it] > numbers[mid].second -> start = mid + 1
            }
        }
    }

    result.forEach { bw.write("$it ") }

    bw.flush()
    bw.close()
}
