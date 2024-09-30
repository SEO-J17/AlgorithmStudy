class Solution {
    int answer = 0;
    boolean visit[];
    
    public int solution(int k, int[][] arr) {
        visit = new boolean[arr.length];
        calc(k, arr, 0, 0);
        return answer;
    }
    private void calc (int k, int[][] arr, int depth, int cnt){
        if(depth == arr.length){
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0 ; i < arr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                int count = cnt;
                int tired = k;
                if(k >= arr[i][0]){
                    count = cnt + 1;
                    tired = k - arr[i][1];
                }
                calc(tired, arr, depth + 1, count);
                visit[i] = false;
            }
        }
    }
}