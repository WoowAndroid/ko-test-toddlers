package solve.boj.boj1743

// 백준 1743 - [실버1] 음식물 피하기
// https://www.acmicpc.net/problem/1743

// 오늘 안에 풀기! = 해결!
/*
* 메모리 초과 원인
* 1. bfs 함수를 실행할 때마다 queue를 새로 생성함. -> 메모리를 쓸데없이 잡아먹음
* 2. visited를 true로 설정하는 로직의 위치: 실제로 방문하기 전 큐에 넣을 때 true로 설정해도 괜찮음
*    -> 방문한 노드를 큐에 중복해서 넣는 불상사 방지 가능
* */
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    // 음식물o: 1, 음식물x: 0
    val passage = Array(n){Array(m){-1}}
    repeat(k) {
        val (r, c) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
        passage[r-1][c-1] = 0
    }
    br.close()

    val answer = lookPassage(n, m, passage)
    val bw = System.out.bufferedWriter()
    bw.write(answer.toString())
    bw.close()
}

fun lookPassage(n: Int, m: Int, passage: Array<Array<Int>>): Int {
    // dx: 상하
    // dy: 좌우
    val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
    val dy: Array<Int> = arrayOf(0, 0, -1, 1)
    val visited = Array(n){Array(m){false}}
    val queue = ArrayDeque<Array<Int>>()
    var answer = 0
    var foodSize: Int
    for(startX in 0 ..< n) {
        for(startY in 0 ..< m) {
            // 음식물이 아니거나, 이미 화인한 음식물이라면 넘어감
            if(passage[startX][startY] == -1 || visited[startX][startY]) continue
            // 만약 음식물을 발견한다면 bfs 순회하여 크기 알아내기
            queue.addLast(arrayOf(startX, startY))
            visited[startX][startY] = true
            foodSize = 0
            while(queue.isNotEmpty()) {
                val foodXY = queue.removeFirst()
                val x = foodXY[0]
                val y = foodXY[1]
                foodSize++
                for (i in dx.indices) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    // 범위를 벗어나면 넘어감
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                    // 음식물이 아니거나 이미 확인한 음식물이라면 넘어감
                    if (passage[nx][ny] == -1 || visited[nx][ny]) continue
                    // 새로 확인할 음식물을 큐에 저장
                    queue.addLast(arrayOf(nx, ny))
                    // 큐에 넣었으니, 미리 방문 완료 처리
                    visited[nx][ny] = true
                }
            }
            // 발견한 음식물 사이즈가 지금까지 중 제일 크다면 answer로 변경
            if (foodSize > answer) answer = foodSize
        }
    }
    return answer
}

//fun bfs(startX: Int, startY: Int, passage: Array<Array<Int>>, n: Int, m: Int): Int {
//    // dx: 상하
//    // dy: 좌우
//    val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
//    val dy: Array<Int> = arrayOf(0, 0, -1, 1)
//    val queue = ArrayDeque<Array<Int>>()
//    var foodSize = 0
//    queue.addLast(arrayOf(startX, startY))
//    while(queue.isNotEmpty()) {
//        val foodXY = queue.removeFirst()
//        val x = foodXY[0]
//        val y = foodXY[1]
//        foodSize++
//        passage[x][y] = foodSize
//        for (i in dx.indices) {
//            val nx = x + dx[i]
//            val ny = y + dy[i]
//            // 범위를 벗어나면 넘어감
//            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
//            // 음식물이 아니거나 이미 확인한 음식물이라면 넘어감
//            if (passage[nx][ny] == -1 || passage[nx][ny] > 0) continue
//            // 새로 확인할 음식물을 큐에 저장
//            queue.addLast(arrayOf(nx, ny))
//        }
//    }
//    return foodSize
//}
