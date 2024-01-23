import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		int result = 999999;

		while (true) {
			if (sum >= s) {
				sum -= arr[start++];
				result = Math.min(cnt, result);
				cnt--;
			} else if (end == n) {
				break;
			} else {
				cnt++;
				sum += arr[end++];
			}
		}
		if (result == 999999) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}
	}
}
