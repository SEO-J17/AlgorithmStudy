import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[], arr2[];
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n];
            arr2 = new int[6];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            calc(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void calc(int depth, int start) {
        if (depth == 6) {
            for (int d : arr2) {
                sb.append(d).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            arr2[depth] = arr[i];
            calc(depth + 1, i + 1);
        }
    }
}
