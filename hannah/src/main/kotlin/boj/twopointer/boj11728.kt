package boj.twopointer

import java.io.*
import java.util.*

// https://www.acmicpc.net/problem/11728
// 메모리 441196KB, 시간 2224ms
fun boj11728() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // PriorityQueue에 값을 넣으면 자동 정렬됨
    // 최소 힙(Min Heap)을 기본으로 하는 이진 트리(Binary Heap) 구조이기 때문에 자동 정렬
    val result = PriorityQueue<Int>()

    br.readLine().split(" ").forEach { result.add(it.toInt()) }
    br.readLine().split(" ").forEach { result.add(it.toInt()) }

    while (result.isNotEmpty()) {
        // joinToString(" ") 는 메모리를 많이 차지할 수 있음
        // 모든 요소를 한 번에 String으로 변환하여 저장하기 때문
        bw.write("${result.poll()} ")
    }
    bw.flush()
    bw.close()
}

// 메모리 428544KB, 시간 1736ms
fun boj11728TwoPointer() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var i = 0
    var j = 0

    while (i < n && j < m) {
        if (a[i] <= b[j]) bw.write("${a[i++]} ")
        else bw.write("${b[j++]} ")
    }

    // b가 모두 먼저 출력된 후 a에 남은 게 있을 수 있음
    while (i < n) { bw.write("${a[i++]} ") }
    // a가 모두 먼저 출력된 후 b에 남은 게 있을 수 있음
    while (j < m) { bw.write("${b[j++]} ") }

    bw.flush()
    bw.close()
}