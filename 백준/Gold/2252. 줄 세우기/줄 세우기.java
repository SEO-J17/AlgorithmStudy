import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int d[] = new int[n + 1];
        List<Integer> list[] = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            d[end]++;
            list[start].add(end);
        }

        ArrayDeque<Integer> qu = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                qu.add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!qu.isEmpty()) {
            int node = qu.poll();
            sb.append(node).append(" ");

            for (int next : list[node]) {
                d[next]--;
                if (d[next] == 0) {
                    qu.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
