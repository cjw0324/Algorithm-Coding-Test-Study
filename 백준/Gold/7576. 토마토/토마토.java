import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int[][] map;
    static int m,n;
    static int green = 0;
    static int day = 0;
    static int count = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) green++;
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    count++;
                }
            }
        }

        int add = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            count--;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    green--;
                    queue.offer(new Point(nx, ny));
                    add++;
                }
            }

            if (count == 0) {
                count = add;
                add = 0;
                day++;
            }
        }

        if (green == 0) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }

    }
}