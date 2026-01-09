class Solution {
    fun solution(n: Int): Int {
        return n.toString().sumOf { it.digitToInt() }
    }
}