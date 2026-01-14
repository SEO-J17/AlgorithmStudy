class Solution {
    fun solution(s: String): Boolean {
        return (s.length == 4 || s.length == 6) && s.all { it.isDigit() }    
    }
}