import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(String[] survey, int[] choices) {
        HashMap<Character,Integer> map = new HashMap();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        for(int i = 0 ; i < choices.length; i++){
            int choice = choices[i];
            String persona = survey[i];
            if(choice == 4){
                continue;
            }
            if(choice < 4){
                char personal = persona.charAt(0);
                int score = map.get(personal);
                map.put(personal, score + (4 - choice));
            }else{
                char personal = persona.charAt(1);
                int score = map.get(personal);
                map.put(personal, score + (choice - 4));
            }   
        }
        
        getAnswer('R','T',map);
        getAnswer('C','F',map);
        getAnswer('J','M',map);
        getAnswer('A','N',map);
        
        return sb.toString();
    }
    private void getAnswer(char c1, char c2, HashMap<Character,Integer> map){
        if(map.get(c1) >= map.get(c2)){
            sb.append(String.valueOf(c1));
        } else {
            sb.append(String.valueOf(c2));
        }
    }
}