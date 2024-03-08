import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            try {
                int num = Integer.parseInt(name);
                sb.append(numMap.get(num));
            } catch (NumberFormatException e) {
                sb.append(nameMap.get(name));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
