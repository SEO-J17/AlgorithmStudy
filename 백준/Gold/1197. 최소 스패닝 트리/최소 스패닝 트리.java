import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node> list[] = new ArrayList[n + 1];
        boolean visit[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[node1].add(new Node(node2, cost));
            list[node2].add(new Node(node1, cost));
        }

        PriorityQueue<Node> qu = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        qu.add(new Node(1, 0));


        long answer = 0;
        while (!qu.isEmpty()) {
            Node current = qu.poll();
            if (!visit[current.dest]) {
                visit[current.dest] = true;

                answer += current.cost;
                for (Node next : list[current.dest]) {
                    if (!visit[next.dest]) {
                        qu.add(next);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
