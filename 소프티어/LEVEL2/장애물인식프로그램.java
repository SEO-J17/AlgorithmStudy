import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static boolean visit[][];
    static int arr[][];
    static int n;
    static int area;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (str.charAt(j) - '0');
            }
        }

        ArrayList<Integer> list = new ArrayList();
        int block = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    block++;
                    area = 1;
                    calc(i, j);
                    list.add(area);
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(block).append("\n");
        for (int d : list) {
            sb.append(d).append("\n");
        }

        System.out.print(sb);
    }

    public static void calc(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (!visit[xx][yy] && arr[xx][yy] == 1) {
                    area++;
                    calc(xx, yy);
                }
            }
        }
    }
}