class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        
        char arr[] = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')){
                answer = false;
                break;
            }
        }
            
        return answer;
    }
}