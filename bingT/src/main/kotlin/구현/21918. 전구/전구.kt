import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    val blobNumbers: Int = input[0]
    val commandNumbers: Int = input[1]
    val blobs: IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    repeat(commandNumbers) {
        val command = br.readLine().split(" ").map { it.toInt() }
        when (command[0]) {
            1 -> {
                change(blobs, command[1], command[2])
            }

            2 -> {
                reverse(blobs, command[1], command[2])
            }

            3 -> {
                turnOff(blobs, command[1], command[2])
            }

            4 -> {
                turnOn(blobs, command[1], command[2])
            }

            else -> {
                throw IllegalArgumentException()
            }
        }
    }
    println(blobs.joinToString(" "))
}

fun change(blobs: IntArray, i: Int, x: Int) {
    blobs[i-1] = x
}

fun turnOff(blobs: IntArray, l: Int, r: Int) {
    for (i in l-1..r-1) {
        blobs[i] = 0
    }
}

fun turnOn(blobs: IntArray, l: Int, r: Int) {
    for (i in l-1..r-1) {
        blobs[i] = 1
    }
}

fun reverse(blobs: IntArray, l: Int, r: Int) {
    for (i in l-1..r-1) {
        blobs[i] = (blobs[i] + 1) % 2
    }
}