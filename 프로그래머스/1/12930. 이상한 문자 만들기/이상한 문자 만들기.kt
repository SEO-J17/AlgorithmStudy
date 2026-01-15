class Solution {
    fun solution(s: String): String {
        var index = 0
        return s.map {
            if (it == ' ') {
                index = 0
                it
            } else {
                if (index++ % 2 == 0) it.uppercase() else it.lowercase()
            }
        }.joinToString("")
    }
}