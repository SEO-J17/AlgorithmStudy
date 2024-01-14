import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
    static int level[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int index = 0;
            parent = new int[n * 2];
            level = new int[n * 2];

            for (int i = 0; i < n * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String person1 = st.nextToken();
                String person2 = st.nextToken();

                if (!map.containsKey(person1)) {
                    map.put(person1, index);
                    index++;
                }

                if (!map.containsKey(person2)) {
                    map.put(person2, index);
                    index++;
                }

                int cnt = union(map.get(person1), map.get(person2));
                sb.append(cnt).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }

        return level[x];
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}