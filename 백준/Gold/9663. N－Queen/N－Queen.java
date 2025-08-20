import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int answer = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i<n; i++) {
            if(isSafe(depth, i)) {
                visited[depth][i] = true;
                dfs(depth + 1);
                visited[depth][i] = false;
            }
        }

    }

    static boolean isSafe(int x, int y) {
        for (int i = 0; i< x; i++) {
            if (visited[i][y]) return false;
        }

        for (int d = 1; d<n; d++) {
            int lx = x - d;
            int ly = y - d;
            int rx = x - d;
            int ry = y + d;
            if (lx >= 0 && ly >= 0) {
                if (visited[lx][ly]) return false;
            }
            if (rx >= 0 && ry >= 0 && ry < n) {
                if(visited[rx][ry]) return false;
            }
        }
        return true;
    }
}