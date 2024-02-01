import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Point(start, end));
        }

        list.sort(((o1, o2) -> Integer.compare(o1.y, o2.y)));

        int answer = 0;
        int time = 0;
        for (Point point : list) {
            // 강의 시작 시간이 전 강의 끝난 시간 보다 크거나 같아야됨
            if (time <= point.x) {
                answer++;
                time = point.y;
            }
        }

        System.out.print(answer);
    }
}