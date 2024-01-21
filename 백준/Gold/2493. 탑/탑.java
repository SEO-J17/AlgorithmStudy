import java.io.*;
import java.util.*;

public class Main {
    static private class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            Node node = new Node(i, num);

            while (!stack.isEmpty()) {
                if (stack.peek().value >= num) {
                    sb.append(stack.peek().index).append(" ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(node);
        }

        System.out.println(sb);
    }
}
