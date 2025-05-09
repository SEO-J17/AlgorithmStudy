import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        calc(0,0,numbers,target);
        return answer;
    }
    
    private void calc(int idx, int sum, int[] arr, int target){
        if(idx >= arr.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        calc(idx + 1, sum + arr[idx], arr, target);
        calc(idx + 1, sum -arr[idx], arr, target);

    }
}