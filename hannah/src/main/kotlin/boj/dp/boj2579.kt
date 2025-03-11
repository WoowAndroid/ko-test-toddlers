package boj.dp

import kotlin.math.max

// https://www.acmicpc.net/problem/2579
fun boj2579() {
    val br = System.`in`.bufferedReader()

    val count = br.readLine().toInt()
    if (count == 1) {
        println(br.readLine().toInt())
        return
    }

    val stairs = IntArray(count) { br.readLine().toInt() }

    val dp = Array(count) { 0 }
    dp[0] = stairs[0]
    dp[1] = stairs[0] + stairs[1]

    if (count > 2) {
        dp[2] = max((stairs[0] + stairs[2]), (stairs[1] + stairs[2]))
    }

    for (i in 3 until count) {
        val scoreA = dp[i - 2] + stairs[i]
        val scoreB = dp[i - 3] + stairs[i - 1] + stairs[i]
        dp[i] = max(scoreA, scoreB)
    }

    println(dp[count - 1])
}

// 아래 코드는 DP가 아닌 그리디로 접근..
//fun boj2579() {
//    val br = System.`in`.bufferedReader()
//    val count = br.readLine().toInt()
//
//    // 마지막 도착 계단은 반드시 밟아야 하니깐 scores를 역순 바꾸고
//    // 초기값을 마지막 도착 계단 점수로 한다면?
//    val stairs = IntArray(count) { br.readLine().toInt() }
//    stairs.reverse()
//
//    // 1. 테이블 정의하기
//    // 3. 초기값 정의하기: 마지막 도착 계단 점수
//    val dp = Array(count) { 0 }
//    dp[0] = stairs[0]
//
//    var n = 1
//    var currentStair = 0
//
//    while (currentStair < count - 1) {
//        if (n == 2) {
//            if (currentStair == count - 2) break
//            currentStair += 2
//            n = 1
//        } else {
//            if (currentStair == count - 2) currentStair++
//            else {
//                if (stairs[currentStair + 1] >= stairs[currentStair + 2]) {
//                    currentStair++
//                    n++
//                } else {
//                    currentStair += 2
//                    n = 1
//                }
//            }
//        }
//        dp[currentStair] = stairs[currentStair]
//    }
//
//    println(dp.sum())
//}