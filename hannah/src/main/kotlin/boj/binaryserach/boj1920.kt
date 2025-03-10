package boj.binaryserach

fun boj1920() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val aNumbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    // 이분탐색, 데이터가 정렬되어 있어야 함
    aNumbers.sort()

    val m = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    val result = Array(m) { 0 }

    repeat (m) {
        var start = 0
        var end = n - 1

        while (start <= end) {
            // mid를 활용해서 매 연산마다 탐색하는 범위를 절반으로 좁혀 나감
            val mid = (start + end) / 2

            when {
                numbers[it] == aNumbers[mid] -> {
                    result[it] = 1
                    break
                }
                numbers[it] > aNumbers[mid] -> start = mid + 1
                numbers[it] < aNumbers[mid] -> end = mid - 1
            }
        }
    }

    result.forEach { bw.write("$it\n") }
    bw.flush()
    bw.close()
}

// 잘못 접근한 풀이: mid 계산은 start, end로 계산해야 함!
//fun boj1920() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//
//    val n = br.readLine().toInt()
//    val aNumbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
//    aNumbers.sort()
//
//    val m = br.readLine().toInt()
//    val numbers = br.readLine().split(" ").map { it.toInt() }
//
//    val result = Array(m) { 0 }
//
//    repeat (m) {
//        var mid = n / 2
//
//        while (mid >= 0 || mid < n) {
//            when {
//                numbers[it] == aNumbers[mid] -> {
//                    result[it] = 1
//                    break
//                }
//                numbers[it] > aNumbers[mid] -> mid /= 2 - 1
//                numbers[it] < aNumbers[mid] -> mid *= 2
//            }
//        }
//    }
//
//    result.forEach { bw.write("$it\n") }
//    bw.flush()
//    bw.close()
//}
