class Solution {
    public int solution(int n) {
        int answer = 0;
        int arr[] = new int[n + 1];
            
        for(int i = 1; i <= n; i++){
            arr[i] = i;
        }
        
        for(int i = 1; i <= n; i++){
            arr[i] += arr[i-1];
        }
        
        int start = 0;
        int end = 1;
             
        while(start < end){
            int sum = arr[end] - arr[start];
            if(sum == n){
                answer++;
                start++;
            }else if(sum < n){
                if(end != n){
                    end++;        
                }else{
                    start++;
                }           
            }else {
                start++;
            }
        }
        
        return answer;
    }
}