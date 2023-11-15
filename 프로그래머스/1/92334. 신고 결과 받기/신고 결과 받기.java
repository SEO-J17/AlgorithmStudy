import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 신고 당한 횟수 맵
        HashMap<String, Integer> reportMap = new HashMap();
        // 신고한 사람 맵 (신고자, 신고한 사람 리스트)
        HashMap<String, ArrayList<String>> reportNameMap = new HashMap();
        
        for(int i = 0 ; i < id_list.length; i++){
            String name = id_list[i];
            reportMap.put(name, 0);
            reportNameMap.put(name, new ArrayList());
        }
        
        for(int i = 0 ; i < report.length; i++){
            String[] arr = report[i].split(" ");
            String name = arr[0];
            String reportName = arr[1];
            ArrayList<String> reportList = reportNameMap.get(name);
            
            if(!reportList.contains(reportName)){
                reportMap.put(reportName, reportMap.get(reportName) + 1);
                reportList.add(reportName);
                reportNameMap.put(name, reportList);
            }
        }
        
        for(int i = 0; i < id_list.length; i++){
            String user = id_list[i];
            ArrayList<String> reportList = reportNameMap.get(user);
            for(String id : reportList){
                if(reportMap.get(id) >= k){
                    answer[i]++;
                }
            }
        }
           
        return answer;
    }
}