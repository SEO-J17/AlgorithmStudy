import java.io.*;
import java.util.*;

public class Main {
    static int arr[][];
    static int n;
    static boolean visit[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int area = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        // 단지 수
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    area = 1;
                    num++;
                    calcDfs(i, j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);
        sb.append(num).append("\n");
        for (int d : list) {
            sb.append(d).append("\n");
        }
        System.out.println(sb);
    }

    private static void calcDfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (arr[xx][yy] == 1 && !visit[xx][yy]) {
                    ++area;
                    calcDfs(xx, yy);
                }
            }
        }
    }
}
