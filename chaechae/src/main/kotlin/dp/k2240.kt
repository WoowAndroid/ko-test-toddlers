package dp

fun main() {
    val (T, W) = readln().split(" ").map { it.toInt() }
    val trees = IntArray(T) { readln().toInt() }

    val dp = Array(T + 1) { IntArray(W + 1) { 0 } }

    if (trees[0] == 1) {
        dp[0][0] = 1
    } else {
        dp[0][1] = 1
    }

    for (i in 1 until T) {
        for (j in 0..W) {
            dp[i][j] = dp[i - 1][j]

            // 자두 받기 가능?
            if ((trees[i] == 1 && j % 2 == 0) || (trees[i] == 2 && j % 2 == 1)) {
                dp[i][j]++
            }

            if (j > 0) {
                var another = dp[i - 1][j - 1]
                if ((trees[i] == 1 && (j - 1) % 2 == 0) || (trees[i] == 2 && (j - 1) % 2 == 1)) {
                    another++
                }
                dp[i][j] = maxOf(dp[i][j], another)
            }
        }
    }

    println(dp[T-1].maxOrNull())
}