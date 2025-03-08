package solve.boj.boj1715

import datastructure.MinHeap2

class Boj1715Solution {
    fun solve() {
        val N = readln().toInt()
        val minHeap = MinHeap2()
        repeat(N) {
            val deck = readln().toInt()
            minHeap.insert(deck)
        }
        var total = 0
        while(minHeap.n != 1) {
            val firstDeck = minHeap.delete()
            val secondDeck = minHeap.delete()
            total += firstDeck + secondDeck
            if (minHeap.n == 0) break
            minHeap.insert(firstDeck + secondDeck)
        }
        println(total)
    }
}
