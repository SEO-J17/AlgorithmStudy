import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int r, c, k;
    static boolean visit[][];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = str.charAt(j);
                if (c == '.') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        visit[r-1][0] = true;
        calc(r - 1, 0, 1);

        System.out.println(answer);
    }

    private static void calc(int x, int y, int distance) {
        if (distance == k) {
            if (x == 0 && y == c - 1) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx >= 0 && yy >= 0 && xx < r && yy < c) {
                if (!visit[xx][yy] && arr[xx][yy] == 0) {
                    visit[xx][yy] = true;
                    calc(xx, yy, distance + 1);
                    visit[xx][yy] =false;
                }
            }
        }
    }
}
