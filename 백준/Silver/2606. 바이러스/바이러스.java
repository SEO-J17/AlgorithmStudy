import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cpu = Integer.parseInt(br.readLine());
		int link = Integer.parseInt(br.readLine());
		int arr[][] = new int[cpu + 1][cpu + 1];
		boolean visit[] = new boolean[cpu + 1];
		for (int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			arr[temp1][temp2] = arr[temp2][temp1] = 1;
		}
		int cnt = 0;
		Queue<Integer> qu = new LinkedList<>();
		qu.add(1);
		visit[1] = true;

		while (!qu.isEmpty()) {
			int temp = qu.poll();
			for (int i = 1; i <= cpu; i++) {
				if (arr[temp][i] == 1 && visit[i] != true) {
					visit[i] = true;
					qu.add(i);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
