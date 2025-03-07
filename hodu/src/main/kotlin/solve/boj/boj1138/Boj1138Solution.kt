package solve.boj.boj1138

// 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억
// N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
// 각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력
fun main() {
    val N = readln().toInt()
    val rememberLeft = readln().split(" ").map{ it.toInt() }
    val order = mutableListOf<Int>()
    for(person in N-1 downTo 0) {
        var idx = 0
        for(o in order) {
            if(idx == rememberLeft[person]) break
            if(o > person + 1) idx++
        }
        order.add(idx, person + 1)
    }
    println(order.joinToString(" "))
}
