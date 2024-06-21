import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int sweet;
        int bit;

        Node(int sweet, int bit) {
            this.sweet = sweet;
            this.bit = bit;
        }
    }

    static Node arr[];
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flavor1 = Integer.parseInt(st.nextToken());
            int flavor2 = Integer.parseInt(st.nextToken());
            arr[i] = new Node(flavor1, flavor2);
        }

        calc(0, 1, 0);
        System.out.println(answer);
    }

    private static void calc(int depth, int sweet, int bit) {
        if (depth == n) {
            if (sweet == 1 && bit == 0) {
                return;
            }
            answer = Math.min(answer, Math.abs(sweet - bit));
            return;
        }

        calc(depth + 1, sweet * arr[depth].sweet, bit + arr[depth].bit);
        calc(depth + 1, sweet, bit);
    }
}
