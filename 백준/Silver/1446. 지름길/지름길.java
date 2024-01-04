import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int start;
        int end;
        int distance;

        Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt((st.nextToken()));
        int d = Integer.parseInt((st.nextToken()));

        ArrayList<Node> list = new ArrayList<>();

        int distance = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt((st.nextToken()));
            int end = Integer.parseInt((st.nextToken()));
            distance = Integer.parseInt((st.nextToken()));

            if (end <= d && end - start > distance) {
                list.add(new Node(start, end, distance));
            }
        }

        list.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int index = 0;
        int move = 0;
        int arr[] = new int[10_001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        while (move <= d) {
            if (index < list.size()) {
                Node node = list.get(index);
                if (node.start == move) {
                    arr[node.end] = Math.min(arr[move] + node.distance, arr[node.end]);
                    index++;
                } else {
                    arr[move + 1] = Math.min(arr[move + 1], arr[move] + 1);
                    move++;
                }
            } else {
                arr[move + 1] = Math.min(arr[move + 1], arr[move] + 1);
                move++;
            }
        }
        System.out.println(arr[d]);
    }
}