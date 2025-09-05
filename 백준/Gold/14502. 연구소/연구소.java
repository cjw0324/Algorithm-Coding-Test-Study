import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Main {
    static int n, m;
    static int[][] map;
    static List<Point> virus = new ArrayList<>();
    static List<Point> empty = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int block = Integer.parseInt(st.nextToken());
                if (block == 2) virus.add(new Point(i, j));
                if (block == 0) empty.add(new Point(i, j));
                map[i][j] = block;
            }
        }

        simulation();

        System.out.println(answer);
    }

    static void bfs(int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        for (Point p : virus) {
            queue.offer(p);
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 2;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    static void simulation() {
        for (List<Point> list : select3wall()) {
            int[][] board = cloneMap();
            for (Point p : list) {
                board[p.x][p.y] = 1;
            }
//            print(board);

            bfs(board);

            count(board);
        }
    }

    static void print(int[][] map) {
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println();
    }


    static int[][] cloneMap() {
        int[][] clone = new int[n][m];
        for (int i = 0; i < n; i++) {
            clone[i] = map[i].clone();
        }
        return clone;
    }

    static void count(int[][] m) {
        int count = 0;
        for (int[] row : m) {
            for (int c : row) {
                if (c == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }


    static List<List<Point>> select3wall() {
        int z = empty.size();
        List<List<Point>> lists = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            for (int j = i + 1; j < z; j++) {
                for (int k = j + 1; k < z; k++) {
                    List<Point> list = new ArrayList<>();
                    list.add(empty.get(i));
                    list.add(empty.get(j));
                    list.add(empty.get(k));
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}

