package solve.boj.boj2178

// 백준 2178 - [실버1] 미로 탐색
// https://www.acmicpc.net/problem/2178

// 1: 이동 가능
// 0: 이동 불가
// (1,1) 출발, (N,M) 도착
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val maze: Array<Array<Int>> = Array(n) { Array(m) {0} }
    repeat(n) {
        val line = br.readLine() ?: ""
        for(i in line.indices) {
            maze[it][i] = line[i].digitToInt()
        }
    }
    br.close()

    val answer = bfs(n-1, m-1, maze, n, m)
    val bw = System.out.bufferedWriter()
    bw.write(answer.toString())
    bw.close()
}

fun bfs(destX: Int, destY: Int, maze: Array<Array<Int>>, n: Int, m: Int): Int {
    // dx: 상 하
    // dy: 좌 우
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)
    // 메모리 초과 -> visited와 answerTable을 함께
    // 방문x : -1, 방문o : 0 초과
    val answerTable = Array(n) { Array(m) {-1} }
    val queue = ArrayDeque<Array<Int>>()

    // (0,0) 부터 시작
    queue.addLast(arrayOf(0,0))
    answerTable[0][0] = 1
    while(queue.isNotEmpty()) {
        val node = queue.removeFirst()
        val x = node[0]
        val y = node[1]
        if(x == destX && y == destY) return answerTable[x][y]
        for(i in dx.indices) {
            val newX = x + dx[i]
            val newY = y + dy[i]
            // 범위 벗어나면 넘어감
            if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue
            // 갈 수 없는 곳이면 넘어감
            if(maze[newX][newY] == 0) continue
            // 이미 방문한 곳이면 넘어감
            if(answerTable[newX][newY] > 0) continue
            // 큐에 추가
            queue.addLast(arrayOf(newX, newY))
            answerTable[newX][newY] = answerTable[x][y] + 1
        }
    }
    return answerTable[destX][destY]
}
