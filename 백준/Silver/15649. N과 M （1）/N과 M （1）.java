import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static int n;
	static int arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		arr = new int[m];
		calc(0, m);
		System.out.println(sb);
	}

	private static void calc(int depth, int m) {
		if (depth == m) {
			for (int d : arr) {
				sb.append(d).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				calc(depth + 1, m);
				visit[i] = false;
			}
		}
	}
}
