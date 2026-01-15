class Solution {
    // 조합 풀이법
    var answer = 0
    fun solution(number: IntArray): Int {
        combination(number, 0, 0, 0)
        return answer
    }
    
    private fun combination(number: IntArray, index: Int, count: Int, currentSum: Int) {
        if (count == 3) {
            if (currentSum == 0) answer++
            return
        }

        for (i in index until number.size) {
            combination(number, i + 1, count + 1, currentSum + number[i])
        }
    }
}