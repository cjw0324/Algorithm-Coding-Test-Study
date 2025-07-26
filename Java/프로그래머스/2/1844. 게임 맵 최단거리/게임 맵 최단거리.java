//BFS 최단거리
import java.util.*;
class Solution {
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] check;
    static int[][] maps;
    
    public int solution(int[][] maps) {
        this.maps = maps.clone();
        check = new int[maps.length][maps[0].length];
        BFS (new Point(0,0));
        
        int answer = check[maps.length - 1][maps[0].length - 1];
        
        if (answer == 0) return -1;
        return answer;
    }
    
    public void BFS (Point p) {
        Queue<Point> queue = new LinkedList<>();
        check[p.x][p.y] = 1;
        queue.offer(p);
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            for (int i = 0; i<4; i++) {
                Point next = move(now, i);
                if (inMap(next)) {
                    queue.offer(next);
                    check[next.x][next.y] = check[now.x][now.y] + 1;
                    maps[next.x][next.y] = 0;
                }
            }
        }  
    }
    
    public Point move(Point p,int i) {
        return new Point(p.x + dx[i], p.y + dy[i]);
    }
    
    public boolean inMap (Point p) {
        if (p.x >= 0 && p.x < maps.length && p.y >= 0 && p.y < maps[0].length && maps[p.x][p.y] == 1) return true;
        return false;
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