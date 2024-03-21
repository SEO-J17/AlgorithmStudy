import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list[] = new ArrayList[n + 1];
        int arr[] = new int[n + 1];
        int answer[] = new int[n + 1];

        Arrays.fill(answer, 1);

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            arr[end]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                qu.add(i);
                answer[i] = 1;
            }
        }

        while (!qu.isEmpty()) {
            int current = qu.poll();

            for (int node : list[current]) {
                arr[node]--;
                if (arr[node] == 0) {
                    answer[node] = answer[current] + 1;
                    qu.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
