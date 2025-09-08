import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; //상 -> 우 -> 하 -> 좌 (시계 방향)
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int x, y, dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dis = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(count);

    }

    static void move() {
        //청소
        if (map[x][y] == 0) {
            count++;
            map[x][y] = 2;
        }

        boolean clean = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[nx][ny] == 0) {
                clean = true;
            }

        }

        if (clean) { // 주변 4칸 중 청소되지 않은 빈칸 있음
            for (int i = 1; i <= 4; i++) {
                int nextDis = dis - i;
                if (nextDis < 0) {
                    nextDis += 4;
                }

                if (map[x + dx[nextDis]][y + dy[nextDis]] == 0) {
                    x += dx[nextDis];
                    y += dy[nextDis];
                    dis = nextDis;
                    move();
                }
            }

        } else { // 주변 4칸 중 청소되지 않은 빈칸 없음
            int nx = x - dx[dis];
            int ny = y - dy[dis];

            if (map[nx][ny] == 1) {
                return;
            }
            x = nx;
            y = ny;
            move();
        }
    }
}