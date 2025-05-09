import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zero_cnt = 0;
        int correct = 0;
        
        for(int i=0; i < 6; i++){
            if(lottos[i] == 0){
                zero_cnt++;
                continue;
            }
            for(int j=0; j < 6; j++){
                if(lottos[i] == win_nums[j]){
                    correct++;
                    break;
                }
            }
        }
        
        correct += zero_cnt;
        
        for(int i=0; i<2; i++){
            if(correct == 6){
                answer[i] = 1;
            }else if(correct == 5){
                answer[i] = 2;
            }else if(correct == 4){
                answer[i] = 3;
            }else if(correct == 3){
                answer[i] = 4;
            }else if(correct == 2){
                answer[i] = 5;
            }else{
                answer[i] = 6;
            }              
            correct -= zero_cnt;                         
        }     
            
        
        return answer;
    }
}