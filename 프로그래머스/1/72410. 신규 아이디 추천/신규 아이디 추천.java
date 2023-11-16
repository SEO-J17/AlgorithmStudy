import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 소문자 치환
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if(i != 0 && c == '.' && sb.length() != 0){
                // 연속된 .이 오지 않게 하기 위함
                if(sb.charAt(sb.length() - 1) == '.'){
                    continue;
                }
            }
            
            if(c >= 'a' && c <= 'z' || c == '-' || c == '_' || c == '.' || c >= '0' && c <='9'){
                sb.append(String.valueOf(c));
            }
        }
        new_id = sb.toString();
        try{
            if(new_id.charAt(0) == '.'){
                new_id = new_id.substring(1, new_id.length());
            }
            
            if(new_id.charAt(new_id.length() - 1) == '.'){
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }catch(StringIndexOutOfBoundsException e){
            new_id = "a";
        }
        
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
        }
        
        if(new_id.charAt(new_id.length() - 1) == '.'){
                new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        if(new_id.length() <=2){
            String s = String.valueOf(new_id.charAt(new_id.length() - 1));
            for(int i = 0; i <= 3 - new_id.length(); i++){
                new_id += s;
            }
        }
        
        
        return new_id;
    }
}