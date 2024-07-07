import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static double[] arr;
    static boolean[][] visit;
    static double answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new double[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        visit = new boolean[30][30];
        answer = 0;
        calc(15, 15, 0, 1);
        System.out.println(answer);
    }

    public static void calc(int x, int y, int idx, double sum) {
        visit[x][y] = true;

        if (idx == n) {
            answer += sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && yy >= 0 && xx < 30 && yy < 30) {
                if (!visit[xx][yy]) {
                    visit[xx][yy] = true;
                    calc(xx, yy, idx + 1, sum * arr[i]);
                    visit[xx][yy] = false;
                }
            }
        }
    }
}
