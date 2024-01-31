import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list[] = new ArrayList[n + 1];
        ArrayList<Integer> reverseList[] = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList();
            reverseList[i] = new ArrayList();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            reverseList[node2].add(node1);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean sVisit[] = new boolean[n + 1];
        sVisit[end] = true;
        calc(start, list, sVisit);

        boolean eVisit[] = new boolean[n + 1];
        eVisit[start] = true;
        calc(end, list, eVisit);

        boolean rSVisit[] = new boolean[n + 1];
        calc(start, reverseList, rSVisit);

        boolean rEVisit[] = new boolean[n + 1];
        calc(end, reverseList, rEVisit);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (sVisit[i] && eVisit[i] && rSVisit[i] && rEVisit[i]) {
                answer++;
            }
        }

        System.out.println(answer - 2);
    }

    public static void calc(int start, ArrayList<Integer> list[], boolean visit[]) {
        if (!visit[start]) {
            visit[start] = true;
            for (int node : list[start]) {
                calc(node, list, visit);
            }
        }
    }
}