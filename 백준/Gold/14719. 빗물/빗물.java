import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < m - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(arr[j], left);
            }

            for (int j = i + 1; j < m; j++) {
                right = Math.max(arr[j], right);
            }

            if (arr[i] < left && arr[i] < right) {
                answer += Math.min(left, right) - arr[i];
            }

        }
        System.out.println(answer);
    }
}
