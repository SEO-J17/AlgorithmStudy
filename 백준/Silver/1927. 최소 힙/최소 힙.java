import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> qu = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if (qu.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(qu.poll()).append("\n");
                }
            } else {
                qu.add((long)cmd);
            }
        }

        System.out.println(sb);

    }
}