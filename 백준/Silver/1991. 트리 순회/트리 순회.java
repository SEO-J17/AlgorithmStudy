import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String left;
        String right;

        Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    static HashMap<String, Node> tree = new HashMap();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            tree.put(root, new Node(leftChild, rightChild));
        }
        
        preOrder("A", tree.get("A"));
        sb.append("\n");
        inOrder("A", tree.get("A"));
        sb.append("\n");
        postOrder("A", tree.get("A"));

        System.out.println(sb);
    }

    // 전위 순회
    static void preOrder(String parent, Node node) {
        if (node == null) {
            return;
        }

        // 루트 노드를 방문
        sb.append(parent);

        // 왼쪽 서브트리를 전위 순회
        preOrder(node.left, tree.get(node.left));

        // 오른쪽 서브트리를 전위 순회
        preOrder(node.right, tree.get(node.right));
    }

    static void inOrder(String parent, Node node) {
        if (node == null) {
            return;
        }

        // 왼쪽 서브트리를 중위 순회
        inOrder(node.left, tree.get(node.left));
        // 루트 노드를 방문
        sb.append(parent);
        // 오른쪽 서브트리를 중위 순회
        inOrder(node.right, tree.get(node.right));
    }

    static void postOrder(String parent, Node node) {
        if (node == null) {
            return;
        }

        // 왼쪽 서브트리를 후위 순회
        postOrder(node.left, tree.get(node.left));

        // 오른쪽 서브트리를 후위 순회
        postOrder(node.right, tree.get(node.right));

        // 루트 노드를 방문
        sb.append(parent);
    }
}


