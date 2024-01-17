import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static int dist[];
    static ArrayList<Node> list[];
    static boolean visit[];
    static int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[startNode].add(new Node(endNode, cost));
            list[endNode].add(new Node(startNode, cost));
        }

        st = new StringTokenizer(br.readLine());

        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int answer = calc(1, node2) +
                calc(node2, node1) +
                calc(node1, n);
        int answer2 = calc(1, node1) +
                calc(node1, node2) +
                calc(node2, n);

        answer = Math.min(answer2, answer);
        if (answer < INF) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static int calc(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);

        PriorityQueue<Node> qu = new PriorityQueue<Node>((((o1, o2) -> Integer.compare(o1.cost, o2.cost))));
        qu.add(new Node(start, 0));
        dist[start] = 0;

        while (!qu.isEmpty()) {
            Node node = qu.poll();

            if (node.dest == end) {
                break;
            }

            if (!visit[node.dest]) {
                visit[node.dest] = true;
                for (Node nextNode : list[node.dest]) {
                    if (dist[nextNode.dest] > dist[node.dest] + nextNode.cost) {
                        dist[nextNode.dest] = dist[node.dest] + nextNode.cost;
                        qu.add(new Node(nextNode.dest, dist[nextNode.dest]));
                    }
                }
            }
        }
        return dist[end];
    }
}