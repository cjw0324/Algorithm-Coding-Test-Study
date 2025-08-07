import java.util.*;
class Solution {
    static final int[] dx = {0,0,-1,1}; //상하좌우 이동에 대한 x 변화량
    static final int[] dy = {1,-1,0,0}; //상하좌우 이동에 대한 y 변화량
    static int[][] maps;
    static int[][] visited;
    static int n,m;
    public int solution(int[][] maps) {
        this.maps = maps.clone();
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        
        BFS(new Point(0,0));
        
        return (visited[n-1][m-1] != 0) ? visited[n-1][m-1] : -1;  
    }
    
    public void BFS(Point p) {
        Queue<Point> queue = new LinkedList<>();
        visited[p.x][p.y] = 1;    // 출발위치의 이동 거리는 0으로 설정
        queue.offer(p);           // 큐에 넣는다
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    Point next = new Point(nx, ny);
                    visited[next.x][next.y] = visited[now.x][now.y] + 1;
                    queue.offer(next);
                }
            }
        }
    }
    
    
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}