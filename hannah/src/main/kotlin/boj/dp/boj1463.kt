package boj.dp

import kotlin.math.min

// https://github.com/WoowAndroid/ko-test-toddlers/wiki
fun boj1463() {
    val n = readln().toInt()

    // 테이블 정의하기
    // D[i] = i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값

    // 초기값 정의하기
    // D[1] = 0
    val table = Array(n + 1) { 0 }

    // 점화식 찾기
    // D[12] = ?
    // 3으로 나누거나 D[12] = D[4] + 1
    // 2로 나누거나 D[12] = D[6] + 1
    // 1을 빼거나 D[12] = D[11] + 1
    for (i in 2 .. n) {
        table[i] = table[i - 1] + 1
        if (i % 2 == 0) table[i] = min(table[i], table[i / 2] + 1)
        if (i % 3 == 0) table[i] = min(table[i], table[i / 3] + 1)
    }

    print(table[n])
}