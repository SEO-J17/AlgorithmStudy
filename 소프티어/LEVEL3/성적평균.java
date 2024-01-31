import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = arr[i] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            double answer;
            if (start == 1) {
                answer = dp[end] / (double) (end - start + 1);
            } else {
                answer = (dp[end] - dp[start - 1]) / (double) (end - start + 1);
            }

            sb.append(String.format("%.2f", answer)).append("\n");
        }

        System.out.println(sb);
    }
}