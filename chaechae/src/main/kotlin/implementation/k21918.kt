package implementation

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val S = readln().split(" ").map { it.toInt() }.toMutableList()

    repeat(M) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        when (a) {
            1 -> function1(S, b, c)

            2 -> function2(S, b, c)

            3 -> function3(S, b, c)

            4 -> function4(S, b, c)
        }
    }

    println(S.joinToString(" "))
}

fun function1(S: MutableList<Int>, i: Int, x: Int): MutableList<Int> {
    S[i - 1] = x
    return S
}

fun function2(S: MutableList<Int>, l: Int, r: Int): MutableList<Int> {
    for (n in l..r) {
        S[n - 1] = if (S[n - 1] == 0) 1 else 0
    }
    return S
}

fun function3(S: MutableList<Int>, l: Int, r: Int): MutableList<Int> {
    for (n in l..r) {
        S[n - 1] = 0
    }
    return S
}

fun function4(S: MutableList<Int>, l: Int, r: Int): MutableList<Int> {
    for (n in l..r) {
        S[n - 1] = 1
    }
    return S
}