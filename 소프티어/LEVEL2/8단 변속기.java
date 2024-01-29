import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int flag = 0;
        for (int i = 1; i < 8; i++) {
            int num = arr[i] - arr[i - 1];

            if (i == 1) {
                if (num > 0) {
                    flag = 1;
                } else {
                    flag = -1;
                }
            } else {
                flag = check(flag, num);
            }

            if (flag == 0) {
                break;
            }
        }

        if (flag == 1) {
            System.out.println("ascending");
        } else if (flag == -1) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

    private static int check(int flag, int num) {
        if (num > 0 && flag == 1) {
            return 1;
        } else if (num < 0 && flag == -1) {
            return -1;
        } else {
            return 0;
        }
    }
}