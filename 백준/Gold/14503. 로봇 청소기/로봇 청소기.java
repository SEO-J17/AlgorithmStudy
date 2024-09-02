import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int cnt = 0;
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(x, y, direction);
        System.out.println(cnt);
    }

    static void calc(int x, int y, int direction) {
        int stand = direction;
        if (arr[x][y] == 0) {
            ++cnt;
            arr[x][y] = 7; // Clean
        }

        boolean isClean = false;
        for (int i = 0; i < 4; i++) {
            int dd = (stand + 3) % 4; // Turn left
            int xx = x + dx[dd];
            int yy = y + dy[dd];

            if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                if (arr[xx][yy] == 0) {
                    calc(xx, yy, dd);
                    isClean = true;
                    return;
                }
            }
            stand = (stand + 3) % 4;
        }

        if (!isClean) {
            int dd = (direction + 2) % 4; // Move backward
            int xx = x + dx[dd];
            int yy = y + dy[dd];
            if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                if (arr[xx][yy] != 1) {
                    calc(xx, yy, direction);
                }
            }
        }
    }
}