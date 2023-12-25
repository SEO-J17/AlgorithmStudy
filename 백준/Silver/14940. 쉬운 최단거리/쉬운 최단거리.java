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
        boolean visit[][] = new boolean[n][m];
        int map[][] = new int[n][m];

        Point start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    start = new Point(i, j);
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = num;
                }
            }
        }

        Queue<Point> qu = new LinkedList<>();
        qu.add(start);
        visit[start.x][start.y] = true;

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        while (!qu.isEmpty()) {
            Point point = qu.poll();
            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (arr[xx][yy] == 1 && !visit[xx][yy]) {
                        map[xx][yy] = map[point.x][point.y] + 1;
                        visit[xx][yy] = true;
                        qu.add(new Point(xx, yy));
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && arr[i][j] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}