import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(num, 0);
        }

        int start = 0;
        int end = 0;
        int answer = 0;

        while (end < arr.length) {
            while (end < arr.length && map.get(arr[end]) + 1 <= m) {
                map.put(arr[end], map.get(arr[end]) + 1);
                end++;
            }
            answer = Math.max(answer, end - start);
            map.put(arr[start], map.get(arr[start]) - 1);
            start++;
        }
        
        System.out.println(answer);
        
    }
}