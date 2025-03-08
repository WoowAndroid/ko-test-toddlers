import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt() // 총 사람 수
    val target = br.readLine().split(" ").map { it.toInt() }
    val bigger = max(target[0], target[1]) - 1
    val smaller = min(target[0], target[1]) - 1
    val M = br.readLine().toInt() // 관계 수
    val parentArray = IntArray(N) { -1 } // 부모 정보
    val childArray: Array<IntArray> = Array(N) { intArrayOf() } // 자식 정보 -> 초기화 헷갈

    repeat(M) {
        val input = br.readLine().split(" ").map { it.toInt() }
        val parent = input[0] - 1
        val child = input[1] - 1
        childArray[parent] = childArray[parent] + child
        parentArray[child] = parent
    }
    println(checkParent(bigger, bigger, smaller, 0, parentArray, childArray))
}

fun checkParent(
    pointer: Int,
    start: Int,
    target: Int,
    cnt: Int,
    parentArray: IntArray,
    childArray: Array<IntArray>,
): Int {
    return if (parentArray[pointer] == target) { // 타겟을 찾으면 촌수 반환
        cnt + 1
    } else if (parentArray[pointer] == -1) { // 내 부모가 없으면, 내 자식 검사
        checkChild(pointer, start, target, cnt + 1, childArray)
    } else { // 내 부모가 있으면, 내 자식들 중에 검사하고 없으면 다시 부모 검사
        val hasChild = checkChild(pointer, start, target, cnt + 1, childArray)
        if (hasChild != -1) hasChild
        else checkParent(parentArray[pointer], start, target, cnt + 1, parentArray, childArray)
    }
}

fun checkChild(pointer: Int, start: Int, target: Int, cnt: Int, childArray: Array<IntArray>): Int {
    val exceptedChilds = childArray[pointer].toMutableList()
    exceptedChilds.remove(start)
    return if (exceptedChilds.isEmpty()) { // 자식들이 없으면
        -1
    } else if (exceptedChilds.contains(target)) {
        cnt
    } else {
        var result = -1
        for (child in exceptedChilds) {
            result = checkChild(child, start, target, cnt + 1, childArray)
            if (result != -1) break
        }
        result
    }
}
