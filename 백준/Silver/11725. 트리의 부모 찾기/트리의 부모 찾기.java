import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer> list[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    static int node[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        node = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list[node1].add(node2);
            list[node2].add(node1);
        }

        calc(1);

        for (int i = 2; i <= n; i++) {
            sb.append(node[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void calc(int child) {
        visit[child] = true;
        for (int nextNode : list[child]) {
            if (!visit[nextNode]) {
                node[nextNode] = child;
                calc(nextNode);
            }
        }
    }
}
