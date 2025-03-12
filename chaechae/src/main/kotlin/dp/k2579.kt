package dp

fun main() {
    val n = readln().toInt()
    val stairs = IntArray(n) { readln().toInt() }

    val dp = Array(n) { IntArray(2) }

    dp[0][0] = stairs[0] // 2칸
    dp[0][1] = 0 // 연속 1칸 (불가능)

    if (n > 1) {
        dp[1][0] = stairs[1]
        dp[1][1] = stairs[0] + stairs[1]
    }

    for (i in 2 until n) {
        dp[i][0] = maxOf(dp[i - 2][0], dp[i - 2][1]) + stairs[i] // 2칸
        dp[i][1] = dp[i - 1][0] + stairs[i] // 연속 1칸

    }

    println(maxOf(dp[n-1][0], dp[n-1][1]))
}
