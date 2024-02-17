//11724
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static boolean arr[][];
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new boolean [n+1][n+1];
		visit = new boolean [n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = true;
			arr[b][a] = true;
			
		}
		
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			if(visit[i] != true) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	
	private static void dfs(int depth) {
		visit[depth] = true;
		
		for(int i = 1; i <= n; i++) {
			if(arr[depth][i] == true && visit[i] != true) {
				dfs(i);
			}
		}
	}
}
