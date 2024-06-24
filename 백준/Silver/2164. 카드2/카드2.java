import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }

        while (qu.size() != 1) {
            qu.poll();
            qu.add(qu.poll());
        }

        System.out.println(qu.peek());
    }
}
