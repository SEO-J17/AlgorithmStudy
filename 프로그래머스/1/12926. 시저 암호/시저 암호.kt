class Solution {
    fun solution(s: String, n: Int): String {
        return s.map { c ->
            when {
                c.isLowerCase() -> {
                    ('a' + (c - 'a' + n) % 26)
                }
                c.isUpperCase() -> {
                    ('A' + (c - 'A' + n) % 26)
                }
                else -> c
            }
        }.joinToString("")
    }
}