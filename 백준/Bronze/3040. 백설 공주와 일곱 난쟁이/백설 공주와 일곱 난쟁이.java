import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int[9];
    static int dwarfArr[] = new int[7];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        calc(0, 0, 0);

        System.out.println(sb);
    }

    private static void calc(int start, int depth, int sum) {
        if (depth == 7) {
            if (sum == 100) {
                for (int d : dwarfArr) {
                    sb.append(d).append("\n");
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            dwarfArr[depth] = arr[i];
            calc(i + 1, depth + 1, sum + arr[i]);
        }
    }
}
