import java.io.*;
import java.util.*;

public class Main {
    private static class Jem {
        int weight;
        int cost;

        Jem(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Jem> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.add(new Jem(m, p));
        }
        list.sort(((o1, o2) -> Integer.compare(o2.cost, o1.cost)));

        int answer = 0;
        for (Jem jem : list) {
            int cost = jem.weight * jem.cost;
            if (jem.weight > w) {
                answer += jem.cost * w;
                break;
            } else {
                answer += jem.cost * jem.weight;
                w -= jem.weight;
            }
        }
        System.out.println(answer);
    }
}