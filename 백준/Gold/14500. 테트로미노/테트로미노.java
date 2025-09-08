import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i,j,map[i][j],1);
                visited[i][j] = false;

                checkTshape(i, j);
            }
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            answer = Math.max(sum, answer);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, sum + map[nx][ny], depth + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    static void checkTshape(int x, int y) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                count++;
                sum += map[nx][ny];
                min = Math.min(min, map[nx][ny]);
            }
        }

        if (count == 4) { // 날개 4개일 때는 하나 빼야 함
            sum -= min;
        }

        if (count >= 3) { // ㅗ 모양 가능
            answer = Math.max(answer, sum);
        }
    }
}