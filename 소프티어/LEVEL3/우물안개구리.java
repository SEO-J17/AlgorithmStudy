import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];
        PriorityQueue<Integer> qu[] = new PriorityQueue[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            qu[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            qu[node1].add(arr[node2]);
            qu[node2].add(arr[node1]);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int myWeight = arr[i];
            if (qu[i].isEmpty()) {
                answer++;
            } else {
                if (myWeight > qu[i].poll()) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}