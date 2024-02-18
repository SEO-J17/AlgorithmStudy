import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        ArrayList<Integer> list[] = new ArrayList[n + 1];
        int job[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int jobTime = Integer.parseInt(st.nextToken());
            int jobNum = Integer.parseInt(st.nextToken());
            job[i] = jobTime;

            for (int j = 0; j < jobNum; j++) {
                int node = Integer.parseInt(st.nextToken());
                list[node].add(i);
                arr[i]++;
            }
        }

        Queue<Integer> qu = new LinkedList<>();
        int time[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            time[i] = job[i];

            if (arr[i] == 0) {
                qu.add(i);
            }
        }

        while (!qu.isEmpty()) {
            int current = qu.poll();

            for (int next : list[current]) {
                arr[next]--;

                time[next] = Math.max(time[next], job[next] + time[current]);
                if (arr[next] == 0) {
                    qu.add(next);
                }
            }
        }

        int answer = 0;
        for (int d : time) {
            answer = Math.max(d, answer);
        }

        System.out.println(answer);
    }
}
