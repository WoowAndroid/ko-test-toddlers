package solve.boj

// 1번 ix : i번째 전구를 x로 변경
// 2번 lr : l번째부터 r번째까지 전구의 상태를 반대로
// 3번 lr : l번째부터 r번째까지 전구를 끔
// 4번 lr : l번째부터 r번째까지 전구를 킴

fun main() {
    val (N, M) = readln().split(" ").map{ it.toInt() }
    val lights = readln().split(" ").map{ it.toInt() }.toMutableList()

    repeat(M) {
        val (command, first, second) = readln().split(" ").map{ it.toInt() }
        lights.runCommand(command, first, second)
    }

    println(lights.joinToString(" "))
}

fun MutableList<Int>.runCommand(command: Int, first: Int, second: Int) {
    when(command) {
        1 -> { this[first - 1] = second }

        2 -> {
            for(i in first - 1 ..< second) {
                if(this[i] == 0) this[i] = 1
                else this[i] = 0
            }
        }

        3 -> {
            for(i in first - 1 ..< second) {
                this[i] = 0
            }
        }

        4 -> {
            for(i in first - 1 ..< second) {
                this[i] = 1
            }
        }

        else -> {
            // do nothing
        }
    }
}
