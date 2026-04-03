import java.util.*;
class Solution {
    static int n,m;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int[][] distance;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        distance = new int[n][m];
        return bfs(new Point(0,0), maps);
    }
    
    static private int bfs(Point p, int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        distance[p.x][p.y] = 1;
        queue.offer(p);
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i<4; i++) {
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && distance[next_x][next_y] == 0 && maps[next_x][next_y] == 1) {
                    queue.offer(new Point(next_x, next_y));
                    distance[next_x][next_y] = distance[now.x][now.y] + 1;
                    if (next_x == n-1 && next_y == m-1) return distance[n-1][m-1];
                }
            }
        }
        return -1;
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}