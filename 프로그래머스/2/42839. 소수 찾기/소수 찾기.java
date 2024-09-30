import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList();
    boolean[] visit;
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++){
            calc(numbers, "" , 0, i + 1);
        }
        
        return list.size();
    }
    
    private void calc(String numbers, String num, int depth, int limit){
        if(limit == depth){
            int n = Integer.parseInt(num);
            if(isPrime(n)){
                if(!list.contains(n)){
                    list.add(n);
                }
            }
            return;
        }
        
        for(int i = 0 ; i < numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                calc(numbers, String.valueOf(numbers.charAt(i)) + num, depth + 1, limit);
                visit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1){
            return false;  
        } 
        for (int i = 2; i <= Math.sqrt(n); i++) {			
            if (n % i == 0){
                return false;  
            } 
        }
        return true;
    }
}