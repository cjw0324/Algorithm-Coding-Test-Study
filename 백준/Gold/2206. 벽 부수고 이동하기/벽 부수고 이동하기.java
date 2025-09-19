import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        boolean[][][] visited = new boolean[n][m][2];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0, 1});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int broken = now[2];
            int dis = now[3];

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println(now[3]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                        visited[nx][ny][broken] = true;
                        queue.offer(new int[]{nx, ny, broken, dis + 1});
                    }

                    if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new int[]{nx, ny, 1, dis + 1});
                    }
                }
            }
        }

        System.out.println(-1);
    }

}