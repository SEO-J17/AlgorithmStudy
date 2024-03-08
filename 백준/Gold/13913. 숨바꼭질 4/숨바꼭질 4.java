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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int limit = (Math.max(m, n) * 2 + 1);
        boolean visit[] = new boolean[limit];
        int arr[] = new int[limit];

        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(n, 0));

        Node answerNode = null;
        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (node.point == m) {
                answerNode = node;
                break;
            }

            int doubleMove = node.point * 2;
            int frontMove = node.point + 1;
            int backMove = node.point - 1;

            if (backMove >= 0 && !visit[backMove]) {
                visit[backMove] = true;
                qu.add(new Node(backMove, node.time + 1));
                arr[backMove] = node.point;
            }

            if (frontMove < limit && !visit[frontMove]) {
                visit[frontMove] = true;
                qu.add(new Node(frontMove, node.time + 1));
                arr[frontMove] = node.point;

            }

            if (doubleMove < limit && !visit[doubleMove]) {
                visit[doubleMove] = true;
                qu.add(new Node(doubleMove, node.time + 1));
                arr[doubleMove] = node.point;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (answerNode == null) {
            sb.append("0").append("\n").append("0");
        } else {
            sb.append(answerNode.time).append("\n");

            Stack<Integer> stack = new Stack<>();
            stack.push(answerNode.point);
            while (true) {
                int num = stack.peek();
                if (num == n) {
                    break;
                }
                stack.push(arr[num]);
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }

        System.out.println(sb);
    }
}
