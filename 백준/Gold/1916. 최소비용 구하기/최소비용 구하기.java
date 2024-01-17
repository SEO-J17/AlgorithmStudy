import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int dest;
        int time;

        Node(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Node> list[] = new ArrayList[n + 1];
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, time));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        PriorityQueue<Node> qu = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.time, o2.time)));
        qu.add(new Node(start, 0));

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (node.dest == destination) {
                break;
            }
            for (Node nextNode : list[node.dest]) {
                if (dist[nextNode.dest] > dist[node.dest] + nextNode.time) {
                    dist[nextNode.dest] = dist[node.dest] + nextNode.time;
                    qu.add(new Node(nextNode.dest, dist[nextNode.dest]));
                }
            }
        }

        System.out.println(dist[destination]);
    }
}
