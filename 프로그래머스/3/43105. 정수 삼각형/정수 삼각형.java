class Solution {
    public int solution(int[][] arr) {
        int dp[][] = new int[arr.length][arr[arr.length - 1].length];
        dp[0][0] = arr[0][0];
        
        for(int i = 1 ; i < arr.length; i++){
            for(int j = 0 ; j < arr[i].length; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][0] + arr[i][0]; 
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];    
                }
                
            }
        }
        
        int answer = 0;
        for(int i = 0 ; i < arr[arr.length - 1].length; i++){
            answer = Math.max(dp[arr.length - 1][i], answer);
        }
        return answer;
    }
}