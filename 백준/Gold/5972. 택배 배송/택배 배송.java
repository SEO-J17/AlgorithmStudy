import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int dist[] = new int[n + 1];
        ArrayList<Node> list[] = new ArrayList[n + 1];
        boolean visit[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }


        PriorityQueue<Node> qu = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        qu.add(new Node(1, 0));
        dist[1] = 0;

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (!visit[node.end]) {
                visit[node.end] = true;
                for (Node nextNode : list[node.end]) {
                    if (dist[nextNode.end] > dist[node.end] + nextNode.cost) {
                        dist[nextNode.end] = dist[node.end] + nextNode.cost;
                        qu.add(new Node(nextNode.end, dist[nextNode.end]));
                    }
                }
            }
        }

        System.out.println(dist[n]);
    }
}
