import java.io.*;
import java.util.*; 
public class Main {
	static char map [][];
	static char map2 [][];
	static boolean visit1[][];
	static boolean visit2[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int normal_cnt,abnormal_cnt,n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char [n][n];			//정상맵
		map2 = new char [n][n];			//색약맵
		visit1 = new boolean [n][n];
		visit2 = new boolean [n][n];
		
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < n; j++) {
					map[i][j] = temp.charAt(j);
					if(temp.charAt(j) == 'G') {
						map2[i][j] = 'R';
					}else
						map2[i][j] = temp.charAt(j);
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visit1[i][j] != true) {		//정상
					normal_dfs(i,j);
					normal_cnt++;
				}
				
				if(visit2[i][j] != true) {		//색약
					abnormal_dfs(i,j);
					abnormal_cnt++;
				}
				
			}
		}
		
		System.out.println(normal_cnt + " " + abnormal_cnt);
		
	}
	
	
	private static void normal_dfs(int x1, int y1) {
		visit1[x1][y1] = true;
		
		for(int i = 0; i < 4; i++) {
			int xx = dx[i]+x1;
			int yy = dy[i]+y1;
			if(xx >= 0 && yy >= 0 && xx < n && yy < n) {
				if((visit1[xx][yy] != true) && (map[x1][y1] == map[xx][yy])) {
					normal_dfs(xx, yy);
				}
			}
		}
	}

	
	private static void abnormal_dfs(int x2, int y2) {
		visit2[x2][y2] = true;
		
		for(int i = 0; i < 4; i++) {
			int xx = dx[i]+x2;
			int yy = dy[i]+y2;
			if(xx >= 0 && yy >= 0 && xx < n && yy < n) {
				if(visit2[xx][yy] != true && map2[x2][y2] == map2[xx][yy]) {
					abnormal_dfs(xx, yy);
				}
			}
		}
	}




}
