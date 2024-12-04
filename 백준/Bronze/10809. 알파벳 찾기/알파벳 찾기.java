import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, -1);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) == -1) {
                map.put(ch, i);
            }
        }

        for (char ch : map.keySet()) {
            sb.append(map.get(ch)).append(" ");
        }

        System.out.println(sb);
    }
}
