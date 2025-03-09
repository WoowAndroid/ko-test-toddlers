package dfs

fun main() {
    // 연금 수급자의 수 N, TV 채널의 수 M, TV에 처음 표시되는 채널 P
    val (N, M, P) = readln().split(" ").map { it.toInt() }

    val favoriteList = IntArray(N) { 0 }
    val dislikeList = IntArray(N) { 0 }

    // 각 연금 수급자가 가장 좋아하는 채널과 싫어하는 채널
    // 연금 수급자 입력 순서는 가장 어린 사람부터 가장 나이 많은 사람 순
    repeat(N) { index ->
        val (favorite, dislike) = readln().split(" ").map { it.toInt() }
        favoriteList[index] = favorite
        dislikeList[index] = dislike
    }

    val visited = mutableSetOf<Int>()
    visited.add(P)

    // 싫어하는 채널 -> 좋아하는 채널로 바꿈
    val answer = channelDfs(P, N, favoriteList, dislikeList, visited, 0)
    println(answer)
}

fun channelDfs(
    channel: Int,
    N: Int,
    favoriteList: IntArray,
    dislikeList: IntArray,
    visited: MutableSet<Int>,
    count: Int
): Int {
    for (i in 0 until N) {
        if (dislikeList[i] == channel) {
            val nextChannel = favoriteList[i]
            if (nextChannel in visited) return -1

            visited.add(nextChannel)
            return channelDfs(nextChannel, N, favoriteList, dislikeList, visited, count + 1)
        }
    }

    return count
}