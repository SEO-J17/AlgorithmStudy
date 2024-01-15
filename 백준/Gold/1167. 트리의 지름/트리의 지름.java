import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int dest;
        int distance;

        Node(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }

    static ArrayList<Node> list[];
    static boolean visit[];
    static int answer;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int targetNode = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                if (list[targetNode] == null) {
                    list[targetNode] = new ArrayList<>();
                }
                list[targetNode].add(new Node(node, distance));
            }
        }

        calc(1, 0);
        visit = new boolean[n + 1];
        calc(node, 0);
        System.out.println(answer);
    }

    private static void calc(int x, int distance) {
        if (distance > answer) {
            answer = distance;
            node = x;
        }
        visit[x] = true;

        for (int i = 0; i < list[x].size(); i++) {
            Node node = list[x].get(i);
            if (!visit[node.dest]) {
                calc(node.dest, distance + node.distance);
            }
        }
    }
}