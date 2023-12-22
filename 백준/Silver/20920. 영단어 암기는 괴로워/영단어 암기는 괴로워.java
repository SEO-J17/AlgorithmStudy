import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt((st.nextToken()));
        int m = Integer.parseInt((st.nextToken()));

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        List<String> list = new ArrayList(map.keySet());
        list.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return map.get(o2) - map.get(o1);
        });

        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key).append("\n");
        }
        
        System.out.println(sb);
    }
}