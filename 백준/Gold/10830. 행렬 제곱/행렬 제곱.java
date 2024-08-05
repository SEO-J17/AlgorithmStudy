import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static long m;
    static int originArr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        originArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                originArr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int answer[][] = calc(originArr, m);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] calc(int[][] arr, Long m) {
        if (m <= 1) {
            return arr;
        }
        int[][] temp = calc(arr, m / 2);

        temp = multi(temp, temp);

        if(m % 2 == 1) {
            temp = multi(temp, originArr);
        }

        return temp;
    }

    private static int[][] multi(int[][] first, int[][] second) {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[i][j] += first[i][k] * second[k][j];
                    temp[i][j] %= 1000;
                }
            }
        }
        return temp;
    }
}
