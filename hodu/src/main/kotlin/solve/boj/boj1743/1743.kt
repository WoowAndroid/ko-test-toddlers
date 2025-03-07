package solve.boj.boj1743

// 백준 1743 - [실버1] 음식물 피하기
// https://www.acmicpc.net/problem/1743

// 오늘 안에 풀기!
fun main() {
    val (n, m, k) = readln().split(" ")?.map{it.toInt()} ?: return
    // 음식물o: 1, 음식물x: 0
    val passage = Array(n){Array(m){-1}}
    repeat(k) {
        val (r, c) = readln().split(" ")?.map{it.toInt()} ?: return
        passage[r-1][c-1] = 1
    }

    val answer = lookPassage(n, m, passage)
    println(answer)
}

fun lookPassage(n: Int, m: Int, passage: Array<Array<Int>>): Int {
    var answer = 0

    // 0,0 부터 n-1,m-1 까지 모두 순회
    for(x in 0 ..< n) {
        for(y in 0 ..< m) {
            // 음식물이 아니라면 넘어감
            if(passage[x][y] == -1) continue
            // 만약 음식물을 발견한다면 bfs 순회하여 크기 알아내기
            val foodSize = bfs(x, y, passage, n, m)
            // 발견한 음식물 사이즈가 지금까지 중 제일 크다면 answer로 변경
            if (foodSize > answer) answer = foodSize
        }
    }
    return answer
}

fun bfs(startX: Int, startY: Int, passage: Array<Array<Int>>, n: Int, m: Int): Int {
    // dx: 상하
    // dy: 좌우
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)
    val queue = ArrayDeque<Array<Int>>()
    var foodSize = 0
    queue.addLast(arrayOf(startX, startY))
    while(queue.isNotEmpty()) {
        val food = queue.removeFirst()
        val x = food[0]
        val y = food[1]
        foodSize++
        passage[x][y] = foodSize
        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (passage[nx][ny] == -1 || passage[nx][ny] > 0) continue
            passage[nx][ny] = foodSize
            queue.addLast(arrayOf(nx, ny))
        }
    }
    return foodSize
}