import java.util.*;

class Solution {
    int answer = 999999;
    ArrayList<Integer> list[];
    boolean visit[];
    int nodeCnt1;
    int nodeCnt2;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i = 0 ; i < wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            list[start].add(end);
            list[end].add(start);
        }
        
        for(int i = 0 ; i < wires.length; i++){
            visit = new boolean[n + 1];
            nodeCnt1 = calc(wires[i][0], wires[i][1], 1);
            nodeCnt2 = calc(wires[i][1], wires[i][0], 1);
            answer = Math.min(Math.abs(nodeCnt1 - nodeCnt2), answer);
        }        
        return answer;
    }
    
    private int calc(int start, int unlink, int cnt){
        visit[start] = true;
        int count = 1;
        
        for(int next : list[start]){
            if(next != unlink){
                if(!visit[next]){
                    count += calc(next, unlink, cnt + 1);
                }
            }
        }
        return count;
    }
}