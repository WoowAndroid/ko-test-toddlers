package programmers

fun main() {
    // 초기 풀이
    class Solution1 {
        fun solution(s: String): IntArray {
            val s1 = s.substring(2, s.length - 2)
            val list = s1.split("},{")

            val result = Array(list.size) { listOf<Int>() }
            val answer = mutableSetOf<Int>()

            for (i in list) {
                val temp = i.split(",").map { it.toInt() }
                result[temp.size - 1] = temp
            }

            for (i in result) {
                answer.addAll(i)
            }

            return answer.toIntArray()
        }
    }

    // sortedBy { it.size } 만 하면 끝나는 풀이였음...... 기억안나요....
    // linkedSetOf<Int>() 를 사용하면 더 좋다고 함.......

    class Solution2 {
        fun solution(s: String): IntArray {
            return s.substring(2, s.length - 2)
                .split("},{")
                .map { it.split(",").map(String::toInt) }
                .sortedBy { it.size }
                .fold(linkedSetOf<Int>()) { acc, list ->
                    acc.apply { addAll(list) }
                }.toIntArray()
        }
    }
}