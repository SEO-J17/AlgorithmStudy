import java.io.*;
import java.util.*;

public class Main {
    static int arr[][];
    static int n, m;
    static boolean visit[][];
    static int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};
    static int dy[] = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            visit = new boolean[n][m];
            arr = new int[n][m];

            if (n == 0 && m == 0) {
                System.out.println(sb);
                return;
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visit[i][j]) {
                        num++;
                        calcDfs(i, j);
                    }
                }
            }
            sb.append(num).append("\n");
        }
    }

    private static void calcDfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                if (arr[xx][yy] == 1 && !visit[xx][yy]) {
                    calcDfs(xx, yy);
                }
            }
        }
    }
}
