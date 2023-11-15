import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Long.toString(n, k);
        String arr[] = num.split("0");
        
        for(String s : arr){
            if(!s.isEmpty() && !s.equals("1")){
                if(isPrime(s)){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(String s) {
        long n = Long.parseLong(s);
	    for (long i = 2; i<=(long)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
	    }
	    return true;
    }
}