import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = Integer.MAX_VALUE;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = INF;
        }
        
        for (int[] item : info) {
            int aCost = item[0]; // A가 훔칠 때 남는 흔적
            int bCost = item[1]; // B가 훔칠 때 남는 흔적
            int[] newDp = new int[n];
            Arrays.fill(newDp, INF);
            
            for (int i = 0; i < n; i++) {
                if (dp[i] == INF) continue; 
               
                int newA = i + aCost;
                if (newA < n) {  
                    newDp[newA] = Math.min(newDp[newA], dp[i]);
                }
                
                int newB = dp[i] + bCost;
                if (newB < m) {  
                    newDp[i] = Math.min(newDp[i], newB);
                }
            }
            dp = newDp;
        }
        
        for (int i = 0; i < n; i++) {
            if (dp[i] < m) {
                return i;
            }
        }
        return -1; // 유효한 상태가 없으면 -1 반환
    }
}