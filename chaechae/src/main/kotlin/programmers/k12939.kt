package programmers

fun main(){
    class Solution1 {
        fun solution(s: String): String {
            val numbers = s.split(" ").map{ it.toInt() }

            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE

            for(n in numbers){
                min = minOf(min, n)
                max = maxOf(max, n)
            }

            var answer = min.toString() + " " + max.toString()

            return answer
        }
    }

    // 시간 복잡도 O(n) 동일
    class Solution2 {
        fun solution(s: String): String {
            val numbers = s.split(" ").map { it.toInt() }
            val min = numbers.minOrNull() ?: 0
            val max = numbers.maxOrNull() ?: 0
            return "$min $max"
        }
    }

    // 성능 높인 방법
    class Solution3 {
        fun solution(s: String): String {
            val numbers = s.split(" ").map { it.toInt() }
            var min = numbers[0]
            var max = numbers[0]

            for (n in numbers) {
                if (n < min) min = n
                else if (n > max) max = n
            }

            return "$min $max"
        }
    }
}