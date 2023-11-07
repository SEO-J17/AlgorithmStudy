import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i = 0 ; i < s.length(); i++){
            String word = String.valueOf(s.charAt(i));
            if(word.equals(" ")){
                sb.append(word);
                idx = 0;
            }else{
                if(idx % 2 == 0){
                    sb.append(word.toUpperCase());
                }else{
                    sb.append(word.toLowerCase());
                }
                idx++;
            }
            
        }
        
        return sb.toString();
    }
}