import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int answer[] = new int[2];
        int value = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == 0) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                break;
            }

            if (value > Math.abs(sum)) {
                value = Math.abs(sum);
                answer[0] = arr[start];
                answer[1] = arr[end];
            }

            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
