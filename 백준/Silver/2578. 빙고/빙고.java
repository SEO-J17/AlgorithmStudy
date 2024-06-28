import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static boolean visit[][];
    static boolean bingo[][];
    static HashMap<Integer, Point> map;
    static int bingoCnt = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        visit = new boolean[5][5];
        bingo = new boolean[5][5];
        map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                map.put(arr[i][j], new Point(i, j));
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                answer++;
                Point point = map.get(num);
                visit[point.x][point.y] = true;
                calc(0, 0);
                bingoCnt = 0;
            }
        }
    }


    private static void check() {
        if (bingoCnt >= 3) {
            System.out.println(answer);
            System.exit(0);
        }
    }

    private static void calc(int col, int row) {
        boolean flag = true;
        for (int j = col; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (!visit[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                bingoCnt++;
            }
            flag = true;
            check();
        }

        for (int j = row; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (!visit[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                bingoCnt++;
            }
            flag = true;
            check();
        }


        for (int i = 0; i < 5; i++) {
            if (!visit[i][i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            bingoCnt++;
        }
        flag = true;

        check();

        for (int i = 0; i < 5; i++) {
            if (!visit[i][4 - i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            bingoCnt++;
        }

        check();
    }
}
