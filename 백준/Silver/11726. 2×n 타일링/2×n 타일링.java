import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n];

        dp[0] = 1;

        if (n == 1) {
            System.out.println(dp[0]);
        } else {
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
            }
            System.out.println(dp[n - 1]);
        }
    }
}
