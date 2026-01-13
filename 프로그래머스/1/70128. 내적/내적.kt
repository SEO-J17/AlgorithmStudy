class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        return a.zip(b) { x, y -> x * y }.sum()
    }
}