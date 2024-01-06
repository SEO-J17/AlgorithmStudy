import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt((st.nextToken()));
        int m = Integer.parseInt((st.nextToken()));

        int arr[][] = new int[n][m];
        boolean visit[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Point> qu = new LinkedList<>();
        qu.add(new Point(0, 0));
        visit[0][0] = true;

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        while (!qu.isEmpty()) {
            Point point = qu.poll();

            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (!visit[xx][yy] && arr[xx][yy] == 1) {
                        visit[xx][yy] = true;
                        arr[xx][yy] = arr[point.x][point.y] + 1;
                        qu.add(new Point(xx, yy));
                    }
                }
            }
        }

        System.out.println(arr[n - 1][m - 1]);
    }
}