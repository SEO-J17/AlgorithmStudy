import java.util.*;
import java.awt.Point;
class Solution {
    public int solution(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        
        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};
        boolean visit[][] = new boolean[n][m];
        int answer = 0;
        
        Queue<Point> qu = new LinkedList();
        qu.add(new Point(0,0));
        visit[0][0] = true;
        
        while(!qu.isEmpty()){
            Point point = qu.poll();
            for(int i = 0 ; i < 4; i++){
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                
                if(xx >= 0 && yy >= 0 && xx < n && yy < m){
                    if(!visit[xx][yy] && map[xx][yy] != 0){
                        visit[xx][yy] = true;
                        map[xx][yy] += map[point.x][point.y];
                        qu.add(new Point(xx, yy));
                    }
                }
            }
        }
        
        if(!visit[n-1][m-1]){
            return -1;
        }
        
        return map[n-1][m-1];
    }
}