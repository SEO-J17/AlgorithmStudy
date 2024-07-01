import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v;
    static ArrayList<Integer> list[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            list[node2].add(node1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        sb.append(v).append(" ");
        visit = new boolean[n + 1];
        calcDfs(v);
        sb.append("\n");

        visit = new boolean[n + 1];
        calcBfs(v);

        System.out.println(sb);
    }

    private static void calcBfs(int node) {
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        visit[node] = true;
        qu.offer(node);

        while (!qu.isEmpty()) {
            int next = qu.poll();
            sb.append(next).append(" ");
            for (int d : list[next]) {
                if (!visit[d]) {
                    qu.offer(d);
                    visit[d] = true;
                }
            }
        }

    }

    private static void calcDfs(int node) {
        visit[node] = true;
        for (int d : list[node]) {
            if (!visit[d]) {
                sb.append(d).append(" ");
                calcDfs(d);
            }
        }
    }
}
