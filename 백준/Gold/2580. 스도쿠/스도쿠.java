import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[][] map = new int[9][9];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
    }

    static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int i = 0; i<9; i++) {
                for (int j = 0; j<9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(map[x][y] == 0) {
            for (int i = 1; i<=9; i++) {
                if (valid(x, y, i)) {
                    map[x][y] = i;
                    dfs(x, y+1);
                }
            }
            map[x][y] = 0;
            return;
        }

        dfs(x, y+1);
    }

    static boolean valid(int x, int y, int num) {
        for (int i = 0; i<9; i++) {
            int row = map[x][i];
            int col = map[i][y];
            if (row == num || col == num) return false;
        }
        int nx = 3 * (x / 3);
        int ny = 3 * (y / 3);

        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                if (num == map[nx + i][ny + j]) return false;
            }
        }
        return true;
    }
}
