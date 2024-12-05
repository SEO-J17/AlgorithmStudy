import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            String str = br.readLine();
            char[] arr = str.toCharArray();
            char before = '@';
            boolean isGroup = true;

            for (int j = 0; j < str.length(); j++) {
                if (before != arr[j] && !set.contains(arr[j])) {
                    before = arr[j];
                    set.add(arr[j]);
                } else if (before != arr[j] && set.contains(arr[j])) {
                    isGroup = false;
                    break;
                }
            }

            if (isGroup) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
