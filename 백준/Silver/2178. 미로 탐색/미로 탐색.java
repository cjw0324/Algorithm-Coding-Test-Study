import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] map;
    static int[][] route;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        route = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(route[i], Integer.MAX_VALUE);
        }
        route[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '1') {
                    if (route[nx][ny] > route[x][y] + 1) {
                        route[nx][ny] = route[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(route[n - 1][m - 1]);

    }
}
