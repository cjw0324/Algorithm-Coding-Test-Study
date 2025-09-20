import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static boolean[] character = new boolean['Z' - 'A' + 1];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = arr[j];
            }
        }

        character[map[0][0] - 'A'] = true;

        dfs(0, 0, 1);

        System.out.println(answer);

    }

    static void dfs(int x, int y, int depth) {

        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !contain(map[nx][ny])) {
                character[map[nx][ny] - 'A'] = true;
                dfs(nx, ny, depth + 1);
                character[map[nx][ny] - 'A'] = false;
            }
        }
    }

    static boolean contain(char c) {
        return character[c - 'A'];
    }
}