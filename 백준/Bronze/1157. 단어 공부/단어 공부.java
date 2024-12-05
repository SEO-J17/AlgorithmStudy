import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toUpperCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        boolean isDuplicate = false;
        char answer = '?';
        int max = 0;
        for (char key : map.keySet()) {
            int num = map.get(key);
            if (max < num) {
                answer = key;
                max = num;
                isDuplicate = false;
            } else if (num == max) {
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }
}
