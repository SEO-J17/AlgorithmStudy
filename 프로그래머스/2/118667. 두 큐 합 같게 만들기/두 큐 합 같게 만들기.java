import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> qu1 = new LinkedList();
        Queue<Integer> qu2 = new LinkedList();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int d : queue1){
            sum1 += d;
            qu1.add(d);
        }
        
        for(int d : queue2){
            sum2 += d;
            qu2.add(d);
        }
        
        while(true){
            if(sum1 == sum2){
                break;
            }
            
            if(sum1 == 0 || sum2 == 0){
                return -1;
            }  
            
            if(sum1 > sum2){
                int value = qu1.poll();
                qu2.add(value);
                sum1 -= value;
                sum2 += value;
            }else{
                int value = qu2.poll();
                qu1.add(value);
                sum1 += value;
                sum2 -= value;
            }
            
            if(answer > (queue1.length + queue2.length) * 2){
                return -1;
            }
            answer++;
        }
        
        
        return answer;
    }
}