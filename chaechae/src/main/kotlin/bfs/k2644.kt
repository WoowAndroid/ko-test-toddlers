package bfs

import java.util.*

fun main() {
    val n = readln().toInt()
    val relation = Array(n + 1) { mutableListOf<Int>() }

    val (targetX, targetY) = readln().split(" ").map { it.toInt() }

    val m = readln().toInt()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        relation[a].add(b)
        relation[b].add(a)
    }

    println(bfsRelationship(relation, targetX, targetY))
}

fun bfsRelationship(relation: Array<MutableList<Int>>, targetX: Int, targetY: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(targetX, 0))

    val visited = mutableSetOf<Int>()
    visited.add(targetX)

    while (queue.isNotEmpty()) {
        val (current, count) = queue.poll()

        if (current == targetY) {
            return count
        } else {
            for (i in relation[current]) {
                if (i !in visited) {
                    queue.add(Pair(i, count+1))
                    visited.add(i)
                }
            }
        }
    }

    return -1
}