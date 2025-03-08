package solve.boj.boj2075

import datastructure.MaxHeap

class Boj2075Solution {
    fun solve() {
        val n = readln().toInt()
//        val maxHeap = MaxHeapUsingMutableList()
        val maxHeap = MaxHeap(3_000_000)
        repeat(n) {
            val nums = readln().split(" ").forEach {
                maxHeap.insert(it.toLong())
            }
        }
        var answer = 0L
        repeat(n) {
            answer = maxHeap.delete()
        }
        println(answer)
    }
}