import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long answer = k;
        for (int i = 0; i < n; i++) {
            answer = (answer * p) % 1000000007;
        }
        System.out.println(answer);
    }
}