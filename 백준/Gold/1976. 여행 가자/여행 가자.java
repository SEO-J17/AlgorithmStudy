import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시의 수
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 1) {
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            if (find(root) != find(Integer.parseInt(st.nextToken()))) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            parent[x] = y;
        } else if (x < y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}