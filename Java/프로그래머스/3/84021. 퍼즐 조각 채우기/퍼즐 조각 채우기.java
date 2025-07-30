import java.util.*;
class Solution {
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {1,-1,0,0};
    static List<List<Point>> blanks = new ArrayList<>();
    static List<List<Point>> puzzles = new ArrayList<>();
    static boolean[] used;
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        bfs(game_board,0,blanks);
        bfs(table, 1,puzzles);
        
        for (List<Point> blank : blanks) {
            shift(blank);
        }
        for (List<Point> puzzle : puzzles) {
            shift(puzzle);
        }
        
        used = new boolean[puzzles.size()];
        
        int b = 0;
        for (List<Point> blank : blanks) {
            boolean pass = false;
            //System.out.println(b + " blank");
            int p = 0;
            for (List<Point> puzzle : puzzles) {
                if (pass) continue;
                //System.out.println(p + " puzzle");
                if (!used[p] && rotate(blank, puzzle)) {
                    answer += blank.size();
                    used[p] = true;
                    pass = true;
                    //System.out.println("answer : " + answer);
                }
                p++;
            }
            b++;
        }
        
        
        return answer;
    }


    
    
    public boolean rotate(List<Point> blank, List<Point> puzzle) {
        for (int i = 0; i<4; i++){
            List<Point> rotatePoints = new ArrayList<>();
            for(Point p : puzzle) {
                if (i == 0) { // 그대로
                    rotatePoints.add(p);
                } else if (i == 1) { //90도 회전
                    rotatePoints.add(new Point(p.y, -1 * p.x));
                } else if (i == 2) { //180도 회전
                    rotatePoints.add(new Point(-1 * p.x, -1 * p.y));
                } else { //270도 회전
                    rotatePoints.add(new Point(-1 * p.y, p.x));
                }
            }
            
            shift(rotatePoints);
            
            int check = 0;
            for (Point b : blank) {
                for (Point p : rotatePoints) {
                    if (b.x == p.x && b.y == p.y) {
                        check++;
                    }
                }
            }
            
            if (check == blank.size() && check == puzzle.size()) {
                return true;
            }
        }
        return false;
    }
    
    
    public void shift(List<Point> points) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (Point p : points) {
            minX = Math.min(p.x, minX);
            minY = Math.min(p.y, minY);
        }

        for (Point p : points) {
            p.x -= minX;
            p.y -= minY;
        }
    }
    
    
    
    
    
    public void bfs(int[][] board, int check, List<List<Point>> save) {
        Queue<Point> queue = new LinkedList<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                List<Point> puzzle = new ArrayList<>();
                if (board[x][y] == check) {
                    Point p = new Point(x,y);
                    queue.offer(p);
                    
                    board[x][y] = (check == 0 ? 1 : 0);
                    
                }
                
                while (!queue.isEmpty()) {
                    Point now = queue.poll();
                    puzzle.add(now);
                    for (int i = 0; i<4; i++) {
                        if (now.x + dx[i] >= 0 &&
                            now.y + dy[i] >= 0 &&
                            now.x + dx[i] < board.length && 
                            now.y + dy[i] < board[0].length && 
                            board[now.x + dx[i]][now.y + dy[i]] == check) {
                            Point next = new Point(now.x + dx[i], now.y + dy[i]);
                            board[next.x][next.y] = (check == 0 ? 1 : 0);
                            queue.offer(next);
                        }
                    }
                }
                if (puzzle.size() > 0) save.add(puzzle);
            }
        }
    }
    
    public class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}