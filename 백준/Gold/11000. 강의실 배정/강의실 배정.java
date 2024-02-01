import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Point(start, end));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        qu.add(list.get(0).y);

        for (int i = 1; i < n; i++) {
            if (qu.peek() <= list.get(i).x) {
                qu.poll();
            }
            qu.add(list.get(i).y);
        }

        System.out.println(qu.size());
    }
}
