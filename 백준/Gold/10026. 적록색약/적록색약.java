import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char arr[][];
    static char arr2[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int n;
    static boolean visit[][];
    static boolean visit2[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        arr2 = new char[n][n];


        visit = new boolean[n][n];
        visit2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'G') {
                    arr2[i][j] = 'R';
                } else {
                    arr2[i][j] = arr[i][j];
                }
            }
        }

        int num = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    num++;
                    calc(i, j, arr[i][j]);
                }
                if (!visit2[i][j]) {
                    num2++;
                    calc2(i, j, arr2[i][j]);
                }
            }
        }

        System.out.println(num + " " + num2);
    }

    private static void calc(int x, int y, char area) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;

            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (!visit[xx][yy] && arr[xx][yy] == area) {
                    calc(xx, yy, area);
                }
            }
        }
    }

    private static void calc2(int x, int y, char area) {
        visit2[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;

            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (!visit2[xx][yy] && arr2[xx][yy] == area) {
                    calc2(xx, yy, area);
                }
            }
        }
    }
}
