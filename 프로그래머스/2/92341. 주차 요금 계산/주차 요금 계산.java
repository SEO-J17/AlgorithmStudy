import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int maxTime = (23 * 60 + 59);
        int basicTime = fees[0];
        int basicFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        // (차량 번호, 들어온 시각)
        HashMap<String, Integer> map = new HashMap();
        //(차량번호, 누적시간)
        TreeMap<String, Integer> timeMap = new TreeMap();
        
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < records.length; i++){
            String arr[] = records[i].split(" ");
            String timeArr[] = arr[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String carNum = arr[1];
            // 이미 입차가 되어있다면
            if(map.containsKey(carNum)){
                int enterTime = map.get(carNum);
                int finalTime = time - enterTime;  
                
                if(timeMap.containsKey(carNum)){
                    timeMap.put(carNum, timeMap.get(carNum) + finalTime);    
                }else{
                    timeMap.put(carNum, finalTime);    
                }
                map.remove(carNum);
            }else{
                map.put(carNum, time);
            }
        }
        
        // 남는 차량
        for(String carNum : map.keySet()){
            int enterTime = map.get(carNum);
            int finalTime = maxTime - enterTime;
            
            if(timeMap.containsKey(carNum)){           
                timeMap.put(carNum, timeMap.get(carNum) + finalTime);    
            }else{
                timeMap.put(carNum, finalTime);    
            }
        }
        
        //요금 계산
        int idx = 0;
        int[] answer = new int[timeMap.size()];
        for(String car : timeMap.keySet()){
            int finalFee = 0;
            int finalTime = timeMap.get(car);
            
            if(finalTime <= basicTime){
                finalFee = basicFee;
            }else{
                finalFee = calcFee(basicFee, finalTime, basicTime, perTime, perFee);      
            }
            answer[idx] = finalFee;
            idx++;
        }
      
        return answer;
    }
    
    public int calcFee(int basicFee, int finalTime, int basicTime, int perTime, int perFee){ 
        return basicFee + (int)Math.ceil((finalTime - basicTime) / (double) perTime) * perFee;
    }
}