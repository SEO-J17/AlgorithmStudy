import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int parent, child;
    static ArrayList<Integer> list[];
    static boolean visit[];
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parent = Integer.parseInt(st.nextToken());
        child = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            list[node2].add(node1);
        }

        calc(parent, 0);

        System.out.println(answer);
    }

    private static void calc(int node, int sum) {
        visit[node] = true;

        if (node == child) {
            answer = sum;
            return;
        }

        for (int childNode : list[node]) {
            if (!visit[childNode]) {
                calc(childNode, sum + 1);
            }
        }
    }
}
