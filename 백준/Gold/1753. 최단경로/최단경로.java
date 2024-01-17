import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int dest;
        int weight;

        Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        ArrayList<Node> list[] = new ArrayList[n + 1];
        int dist[] = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[node1].add(new Node(node2, weight));
        }

        PriorityQueue<Node> qu = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        dist[startNode] = 0;
        qu.add(new Node(startNode, 0));

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            for (Node nextNode : list[node.dest]) {
                if (dist[nextNode.dest] > dist[node.dest] + nextNode.weight) {
                    dist[nextNode.dest] = dist[node.dest] + nextNode.weight;
                    qu.add(new Node(nextNode.dest, dist[nextNode.dest]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (dist[i] < Integer.MAX_VALUE) {
                sb.append(dist[i]);
            } else {
                sb.append("INF");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
