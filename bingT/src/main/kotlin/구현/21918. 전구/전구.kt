import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    val commandNumbers: Int = input[1]
    val bulbs: IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    repeat(commandNumbers) {
        val command = br.readLine().split(" ").map { it.toInt() }
        when (command[0]) {
            1 -> {
                change(bulbs, command[1], command[2])
            }

            2 -> {
                reverse(bulbs, command[1], command[2])
            }

            3 -> {
                turnOff(bulbs, command[1], command[2])
            }

            4 -> {
                turnOn(bulbs, command[1], command[2])
            }

            else -> {
                throw IllegalArgumentException()
            }
        }
    }
    println(bulbs.joinToString(" "))
}

fun change(bulbs: IntArray, i: Int, x: Int) {
    bulbs[i-1] = x
}

fun turnOff(bulbs: IntArray, l: Int, r: Int) {
    for (i in l-1..r-1) {
        bulbs[i] = 0
    }
}

fun turnOn(bulbs: IntArray, l: Int, r: Int) {
    for (i in l-1..r-1) {
        bulbs[i] = 1
    }
}

fun reverse(bulbs: IntArray, l: Int, r: Int) {
    for (i in l-1..r-1) {
        bulbs[i] = (bulbs[i] + 1) % 2
    }
}
