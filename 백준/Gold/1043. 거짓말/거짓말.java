import java.io.*;
import java.util.*;

public class Main {
    static int parent[];
    static ArrayList<Integer> party[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 수, 진실을 아는 사람 번호
        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 배열
        int truePeople[] = new int[trueNum];
        for (int i = 0; i < trueNum; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[m];
        parent = new int[n + 1];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());

            for (int j = 0; j < people; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 유니온 파인드를 위한 자기 자신 번호로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int fistPerson = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(fistPerson, party[i].get(j));
            } // 각각의 파티에 참석한 인원들은 같은 집합으로 분류함
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int person = party[i].get(0);
            boolean flag = true;

            for (int j = 0; j < trueNum; j++) {
                // 진실을 아는 사람과 같은 파티라면
                if (find(person) == find(truePeople[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // 다른 집합일때 묶기, 작은 번호가 루트노드가 될수 있도록.
        if (x < y) {
            parent[y] = x;
        } else if (x > y) {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}
