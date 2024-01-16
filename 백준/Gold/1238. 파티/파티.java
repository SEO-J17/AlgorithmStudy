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

    static ArrayList<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if (list[node1] == null) {
                list[node1] = new ArrayList<>();
            }
            list[node1].add(new Node(node2, time));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int time = calc(i, x, n) + calc(x, i, n);
            answer = Math.max(time, answer);

        }
        System.out.println(answer);
    }

    private static int calc(int start, int destination, int n) {
        boolean visit[] = new boolean[n + 1];
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> qu = new PriorityQueue<Node>(((o1, o2) -> Integer.compare(o1.time, o2.time)));
        qu.add(new Node(start, 0));

        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (!visit[node.dest]) {
                visit[node.dest] = true;

                for (Node nextNode : list[node.dest]) {
                    if (dist[nextNode.dest] > dist[node.dest] + nextNode.time) {
                        dist[nextNode.dest] = dist[node.dest] + nextNode.time;
                        qu.add(new Node(nextNode.dest, dist[nextNode.dest]));
                    }
                }
            }
        }

        return dist[destination];
    }
}