import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String todayArr[] = today.split("\\.");
        int todayDate = toInt(todayArr[0]) * 12 * 28 + toInt(todayArr[1]) * 28 + toInt(todayArr[2]);
        HashMap<String, Integer> map = new HashMap();
        ArrayList<Integer> list = new ArrayList();

        for(int i = 0; i < terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(), toInt(st.nextToken()) * 28);
        }
        
        for(int i = 0 ; i < privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String privacyDate = st.nextToken();
            String info = st.nextToken();
            String currentDate[] = privacyDate.split("\\.");
            int limitDate = toInt(currentDate[0]) * 12 * 28 + toInt(currentDate[1]) * 28 + toInt(currentDate[2]) + map.get(info);
            
            if(todayDate >= limitDate){
                list.add(i + 1);
            }
        }
        
        int answer[] = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int toInt(String str){
        return Integer.parseInt(str);
    }
}