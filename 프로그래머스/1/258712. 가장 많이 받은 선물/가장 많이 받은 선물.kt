class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val indexMap = friends.withIndex().associate{ it.value to it.index }
        val n = friends.size
        val giftArr = Array(n) { IntArray(n) }
        val giftScore = IntArray(n)
        
        gifts.forEach {
            val (sender, receiver) = it.split(" ")
            val g1 = indexMap[sender]!!
            val r1 = indexMap[receiver]!!
            giftArr[g1][r1]++
            giftScore[g1]++
            giftScore[r1]--
        }
        
        val nextGift = IntArray(n)
        for(i in 0 until n){
            for(j in 0 until n){
                if(i == j) continue
                val receiver = giftArr[i][j]
                val sender = giftArr[j][i]
    
                if(sender > receiver){
                    nextGift[j]++
                }else if(sender == receiver && giftScore[j] > giftScore[i]){
                    nextGift[j]++
                }
            }
        }
        
        return nextGift.maxOrNull() ?: 0
    }
}