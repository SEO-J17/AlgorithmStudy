import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int start;
        int end;
        int time;

        Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        // 벨만포드 알고리즘 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        ArrayList<Node> list = new ArrayList();
        long dist[] = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, time));
        }

        dist[1] = 0;

        // 정점의 수만큼 반복
        for (int i = 0; i <= n; i++) {
            // 간선의 수만큼 반복
            for (Node node : list) {
                if (dist[node.start] != Long.MAX_VALUE) {
                    if (dist[node.end] > dist[node.start] + node.time) {
                        // 음수 사이클 존재, n 번째에서도 값이 갱신되었다는 것.
                        if (i == n) {
                            System.out.println(-1);
                            System.exit(0);
                        }

                        dist[node.end] = dist[node.start] + node.time;
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] < Long.MAX_VALUE) {
                sb.append(dist[i]);
            } else {
                sb.append(-1);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
