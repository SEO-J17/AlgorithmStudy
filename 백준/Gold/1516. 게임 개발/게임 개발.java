import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int time[] = new int[n + 1];
        int arr[] = new int[n + 1];
        ArrayList<Integer> list[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int jobTime = Integer.parseInt(st.nextToken());
            time[i] = jobTime;

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }

                list[num].add(i);
                arr[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int dp[] = new int[n + 1];
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                qu.add(i);
                dp[i] = time[i];
            }
        }

        while (!qu.isEmpty()) {
            int current = qu.poll();

            for (int next : list[current]) {
                arr[next]--;
                dp[next] = Math.max(dp[next], dp[current] + time[next]);

                if (arr[next] == 0) {
                    qu.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append("\n");
        }

        System.out.println(sb);
    }
}
