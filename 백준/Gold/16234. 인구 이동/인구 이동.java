import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int n, l, r, area;
	static boolean visit[][];
	static int arr[][];
	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// l이상 r이하
		int cnt = 0;
		boolean flag = false;
		while (!flag) {
			flag = true;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					list = new ArrayList<>();
					area = 0;
					if (!visit[i][j]) {
						calc(i, j);
						if (list.size() == 1) {
							continue;
						} else {
							flag = false;
							int sum = 0;
							for (Point point : list) {
								sum += arr[point.x][point.y];
							}
							int people = sum / area;
							for (Point point : list) {
								arr[point.x][point.y] = people;
							}
						}
					}
				}
			}
			if (flag) {
				break;
			} else {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static void calc(int x, int y) {
		visit[x][y] = true;
		list.add(new Point(x, y));
		area++;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && xx < n && yy >= 0 && yy < n) {
				if (!visit[xx][yy] && Math.abs(arr[x][y] - arr[xx][yy]) >= l
						&& Math.abs(arr[x][y] - arr[xx][yy]) <= r) {
					calc(xx, yy);
				}
			}
		}

	}
}
