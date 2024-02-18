import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];
        ArrayList<Integer> list[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            arr[node2]++;
        }

        Queue<Integer> qu = new LinkedList<>();


        // 진입 차수가 0 이라면 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                qu.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!qu.isEmpty()) {
            int current = qu.poll();
            sb.append(current).append(" ");

            for (int next : list[current]) {
                arr[next]--;
                // 진입 차수가 0 이라면 큐에 삽입
                if (arr[next] == 0) {
                    qu.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
