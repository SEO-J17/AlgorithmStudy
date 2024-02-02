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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node> list[] = new ArrayList[n + 1];
        int dist[] = new int[n + 1];
        boolean visit[] = new boolean[n + 1];

        Arrays.fill(dist, Integer.MIN_VALUE);
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> qu = new PriorityQueue<Node>(((o1, o2) -> o2.cost - o1.cost));
        dist[start] = Integer.MAX_VALUE;
        qu.add(new Node(start, Integer.MAX_VALUE));

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (!visit[node.dest]) {
                visit[node.dest] = true;
                for (Node nextNode : list[node.dest]) {
                    int maxWeight = Math.min(nextNode.cost, node.cost);
                    if (maxWeight > dist[nextNode.dest]) {
                        dist[nextNode.dest] = maxWeight;
                        qu.add(new Node(nextNode.dest, dist[nextNode.dest]));
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }
}
