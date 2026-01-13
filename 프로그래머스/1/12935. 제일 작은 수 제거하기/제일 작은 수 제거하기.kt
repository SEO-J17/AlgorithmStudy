class Solution {
    fun solution(arr: IntArray): IntArray {
        if (arr.size == 1) return intArrayOf(-1)
        val min = arr.minOrNull()!!
        return arr.filter { it != min }.toIntArray()
    }
}