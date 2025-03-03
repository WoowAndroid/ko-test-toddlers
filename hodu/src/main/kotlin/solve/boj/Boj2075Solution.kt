package solve.boj

import datastructure.MaxHeapUsingMutableList

class Boj2075Solution {
    fun solve() {
        val n = readln().toInt()
        val maxHeap = MaxHeapUsingMutableList()
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