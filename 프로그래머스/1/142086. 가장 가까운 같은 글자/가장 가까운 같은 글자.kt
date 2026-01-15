class Solution {
    fun solution(s: String): IntArray {
        val lastSeenMap = mutableMapOf<Char, Int>()

        return IntArray(s.length) { i ->
            val currentChar = s[i]
            
            val result = if (lastSeenMap.containsKey(currentChar)) {
                i - lastSeenMap[currentChar]!! 
            } else {
                -1
            }
            lastSeenMap[currentChar] = i
            result
        }
    }
}