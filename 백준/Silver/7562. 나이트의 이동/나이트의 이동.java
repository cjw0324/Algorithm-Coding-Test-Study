import java.io.*;
import java.util.*;
import java.awt.*;
public class Main {
    static int T;
    static int[] dx = {-2, -1, 1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static boolean[][] visited;
    static int[][] dist;
    static int l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T ; t++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine(), " ");
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(bfs(start, end)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static int bfs(Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[l][l];
        dist = new int[l][l];
        visited[start.x][start.y] = true;
        queue.offer(start);
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;

            if (x == end.x && y == end.y) return dist[end.x][end.y];

            for (int i = 0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l || visited[nx][ny]) continue;

                dist[nx][ny] = dist[x][y] + 1;
                visited[nx][ny] = true;

                queue.offer(new Point(nx, ny));
            }
        }

        return -1;
    }



}
