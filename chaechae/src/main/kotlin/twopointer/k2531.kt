package twopointer

fun main() {
    // 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
    val br = System.`in`.bufferedReader()
    val (N, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val sushi = IntArray(N) { br.readLine().toInt() }

    // 1. 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인
    // 2. 1번 행사에 참가할 경우 이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공
    // (만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공)

    val current = mutableMapOf<Int, Int>()

    for (i in 0 until k) {
        current[sushi[i]] = current.getOrDefault(sushi[i], 0) + 1
    }
    var uniqueCount = current.size + if (current.containsKey(c)) 0 else 1

    var maxCount = uniqueCount

    for (i in 0 until N) {
        val remove = sushi[i]
        current[remove] = current.getOrDefault(remove, 0) - 1
        if (current[remove] == 0) current.remove(remove)

        val add = sushi[(i + k) % N]
        current[add] = current.getOrDefault(add, 0) + 1

        uniqueCount = current.size
        if (!current.containsKey(c)) uniqueCount++

        maxCount = maxOf(maxCount, uniqueCount)
    }

    println(maxCount)
}
