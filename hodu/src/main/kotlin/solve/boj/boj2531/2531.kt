package solve.boj.boj2531

// 백준 2531 - [실버1] 회전 초밥
// https://www.acmicpc.net/problem/2531

// 1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인
// 2. 각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행, 1번 행사 참여할 경우,
//    이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공, 없으면 만듦
// 손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하라

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, d, k, coupon) = br.readLine()?.split(" ")?.map{it.toInt()} ?: return
    val circularBelt = mutableListOf<Int>()
    repeat(n) {
        val sushi = br.readLine()?.toInt() ?: 0
        circularBelt.add(sushi)
    }

    var to = k - 1
    var maxDishType = 0
    val dishes = ArrayDeque<Int>()
    for(i in 0..to) dishes.addLast(circularBelt[i])
    while (true) {
        dishes.addLast(coupon)
        val dishType = dishes.toSet().size
        if (maxDishType < dishType) maxDishType = dishType
        dishes.removeLast()
        if(to + 1 == k - 1) break
        dishes.removeFirst()
        to = (to + 1) % n
        dishes.addLast(circularBelt[to])
    }
    val bw = System.out.bufferedWriter()
    bw.write(maxDishType.toString())
    bw.close()
}