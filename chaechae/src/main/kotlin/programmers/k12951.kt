package programmers

fun main() {
    // 첫번째 공백일때의 case를 유지 못함!!
    class Solution1 {
        fun solution(s: String): String {
            val s1 = s.split(" ")
            val result = mutableListOf<String>()

            for (i in s1) {
                if (i.isNotEmpty()) {
                    val isNull = i[0].toString().toIntOrNull()
                    var new = ""

                    if (isNull == null) {
                        new = i[0].toUpperCase().toString()
                    } else {
                        new = i[0].toString()
                    }

                    for (j in 1 until i.length) {
                        new += i[j].toLowerCase()
                    }
                    result.add(new)
                }
            }

            return result.joinToString(" ")
        }
    }

    class Solution2 {
        fun solution(s: String): String {
            val s1 = s.split(" ")
            val result = mutableListOf<String>()

            for (i in s1) {
                if (i.isNotEmpty()) {
                    var new = ""

                    if (i[0].isLetter()) {
                        new = i[0].uppercase() + i.substring(1).lowercase()
                    } else {
                        new = i[0].toString() + i.substring(1).lowercase()
                    }

                    result.add(new)
                } else {
                    result.add("")
                }
            }

            return result.joinToString(" ")
        }
    }
}