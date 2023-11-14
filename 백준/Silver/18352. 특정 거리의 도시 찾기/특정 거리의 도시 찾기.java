import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken());
		int road = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		// 메모리 초과로 인한 인접리스트 사용.
		ArrayList<ArrayList<Integer>> list = new ArrayList();
		boolean visit[] = new boolean[city + 1];
		for (int i = 0; i <= city; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> qu = new LinkedList<>();
		qu.add(start);
		visit[start] = true;
		int cnt = 0;
		while (!qu.isEmpty()) {
			if (cnt == distance) {
				break;
			}
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				int temp = qu.poll();
				for (int j = 0; j < list.get(temp).size(); j++) {
					int node = list.get(temp).get(j);
					if (!visit[node]) {
						qu.add(node);
						visit[node] = true;
					}
				}
			}
			cnt++;
		}

		
		StringBuilder sb = new StringBuilder();
		if (!qu.isEmpty()) {
			ArrayList<Integer> result = new ArrayList<>();
			for(int d : qu) {
				result.add(d);
			}
			Collections.sort(result);
			for (int d : result) {
				sb.append(d).append("\n");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}

	}

}
