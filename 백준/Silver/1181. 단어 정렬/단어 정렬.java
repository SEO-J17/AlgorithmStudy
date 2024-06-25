import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for (String str : set) {
            list.add(str);
        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
