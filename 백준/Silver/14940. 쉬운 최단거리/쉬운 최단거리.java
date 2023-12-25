import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int arr[][] = new int[n][m];

        Point start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    start = new Point(i, j);
                    arr[i][j] = 0;
                } else if (num == 1) {
                    arr[i][j] = -1;
                }
            }
        }

        Queue<Point> qu = new LinkedList<>();
        qu.add(start);

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        while (!qu.isEmpty()) {
            Point point = qu.poll();
            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (arr[xx][yy] == -1) {
                        arr[xx][yy] = arr[point.x][point.y] + 1;
                        qu.add(new Point(xx, yy));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}