package boj.dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// https://www.acmicpc.net/problem/10552
fun boj10552() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, p) = br.readLine().split(" ").map { it.toInt() }

    // 현재 채널을 싫어 하는 사람이 있는지 쉽게 찾기 위해 preferences의 키를 싫어 하는 채널로 두자.
    val preferences = mutableMapOf<Int, Int>()

    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        // 현재 채널을 싫어 하는 연금 수급자가 여러 명이면 그 중 막내가 자신이 좋아하는 채널로 변경
        // 즉, 현재 채널을 싫어 하는 연금 수급자가 여러 명이면 막내가 바꾼 채널만 고려 하면 됨
        // 가장 어린 사람 부터 입력 되기 떄문에 이미 preferences가 y라는 키를 가지고 있다는 것은 막내가 저장된 것
        // 🚨막내가 이미 저장된 상태면 값을 덮어 씌우면 안됨..! 이러니 안되지,,, 멍청아
        if (!preferences.containsKey(y)) preferences[y] = x
    }

    val visit = Array(m) { false }
    var count = 0

    val stack = Stack<Int>()
    stack.push(p)

    while (stack.isNotEmpty()) {
        val currentChannel = stack.pop()

        if (!preferences.containsKey(currentChannel)) return print(count)
        // currentChannel - 1을 해야하는 이유? currentChannel 은 1부터 시작, visit의 idx는 0부터 시작 한다.
        if (visit[currentChannel - 1]) return print(-1)

        visit[currentChannel - 1] = true
        count++
        stack.push(preferences[currentChannel])
    }
}
