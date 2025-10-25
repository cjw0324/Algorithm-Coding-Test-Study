import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static int[][][] dist;
    static int n;
    static int INF = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        n = board.length;
        dist = new int[n][n][4];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }
        
        return bfs(board);
    }
    
    static int bfs(int[][] board) {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        pq.offer(new Point(0,0,1,0));
        pq.offer(new Point(0,0,3,0));
        
        while(!pq.isEmpty()) {
            Point now = pq.poll();
            int x = now.x;
            int y = now.y;
            int d = now.d;
            int cost = now.cost;
            
            if (x == n - 1 && y == n - 1) {  
                return cost;
            }
            for (int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;
                
                int nc = cost + 100;
                if (d != i) nc += 500;
                
                if (nc < dist[nx][ny][i]) {
                    dist[nx][ny][i] = nc;
                    pq.offer(new Point(nx, ny, i, nc));
                }
            }
        }

        return -1;
    }
    
    static class Point {
        int x;
        int y;
        int d;
        int cost;
        public Point(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = c;
        }
    }
}