class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val ansewer = IntArray(2)
        
        var cnt = 0
        var zeroCnt = 0
        
        lottos.filter{it != 0}.toHashSet().also { lottoSet ->
           win_nums.forEach {
               if(lottoSet.contains(it)){
                   cnt++
               }
           }
           zeroCnt = lottos.size - lottoSet.size
        }
        
        ansewer[0] = chkWinner(cnt + zeroCnt)
        ansewer[1] = chkWinner(cnt)
        
        return ansewer
    }
    
    fun chkWinner(cnt : Int) : Int{
        return when(cnt){
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
    }
}