import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int point;
        int time;

        Node(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt((st.nextToken()));
        int k = Integer.parseInt((st.nextToken()));

        boolean visit[] = new boolean[100_001];
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(n, 0));
        visit[n] = true;

        int answer = 0;
        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (node.point == k) {
                answer = node.time;
                break;
            }

            int doubleMove = node.point * 2;
            int frontMove = node.point + 1;
            int backMove = node.point - 1;

            if (doubleMove <= 100_000 && doubleMove >=0 && !visit[doubleMove]) {
                visit[doubleMove] = true;
                qu.add(new Node(doubleMove, node.time));
            }

            if (backMove <= 100_000 && backMove >= 0 && !visit[backMove]) {
                visit[backMove] = true;
                qu.add(new Node(backMove, node.time + 1));
            }
            
            if (frontMove <= 100_000 && frontMove >= 0 && !visit[frontMove]) {
                visit[frontMove] = true;
                qu.add(new Node(frontMove, node.time + 1));
            }


        }

        System.out.println(answer);
    }

}