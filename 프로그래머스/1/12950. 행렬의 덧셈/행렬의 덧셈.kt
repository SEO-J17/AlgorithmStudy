class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        return arr1.zip(arr2) { row1, row2 ->
            row1.zip(row2) { x, y ->
                 x + y
            }.toIntArray() 
        }.toTypedArray() 
    }   
}