import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val array: Array<Array<Char>> = Array(N) { Array(N) { 'V' } }
    val array2: Array<Array<Char>> = Array(N) { Array(N) { 'V' } }
    repeat(N) {
        val a = readLine().toCharArray() // String 입력 -> Char로 바꾸기
        array[it] = a.toTypedArray()
        array2[it] = a.toTypedArray()
    }
    var cnt = 0
    var cnt2 = 0
    for (y in 0 until N) {
        for (x in 0 until N) {
            if (array[y][x] != 'V') {
                dfs(y, x, array[y][x], array, N)
                cnt++
            }
            if (array2[y][x] != 'V') {
                dfs2(y, x, array2[y][x], array2, N)
                cnt2++
            }
        }
    }
    println("$cnt $cnt2")
}

fun dfs(y: Int, x: Int, flag: Char, array: Array<Array<Char>>, N: Int) {
    if (array[y][x] == flag) {
        array[y][x] = 'V'
        if (y < N - 1) dfs(y + 1, x, flag, array, N)
        if (x < N - 1) dfs(y, x + 1, flag, array, N)
        if (0 < y) dfs(y - 1, x, flag, array, N)
        if (0 < x) dfs(y, x - 1, flag, array, N)
    }
}

fun dfs2(y: Int, x: Int, flag: Char, array: Array<Array<Char>>, N: Int) {
    val isSpecialCase = ((array[y][x] == 'G' && flag == 'R') || (array[y][x] == 'R' && flag == 'G'))
    if (array[y][x] == flag || isSpecialCase) {
        array[y][x] = 'V'
        if (y < N - 1) dfs2(y + 1, x, flag, array, N)
        if (x < N - 1) dfs2(y, x + 1, flag, array, N)
        if (0 < y) dfs2(y - 1, x, flag, array, N)
        if (0 < x) dfs2(y, x - 1, flag, array, N)
    }
}