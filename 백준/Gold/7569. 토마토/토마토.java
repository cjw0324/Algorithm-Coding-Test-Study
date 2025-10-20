

import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int[] dz = {1, -1};
    static int m, n, h;
    static int date = 0;
    static int[][][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];

        Queue<Point> queue = new LinkedList<>();
        int before = 0;
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int y = 0; y < m; y++) {
                    map[z][x][y] = Integer.parseInt(st.nextToken());
                    if (map[z][x][y] == 1) {
                        queue.offer(new Point(x, y, z));
                    }

                    if (map[z][x][y] == 0) {
                        before++;
                    }
                }
            }
        }

        if (before == 0) {
            System.out.println(0);
            return;
        }

        int count = queue.size();
        int added = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            count--;

            // 같은 평면에서 상,하,좌,우
            for (int i = 0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z;

                if (check(nx, ny, nz)) {
                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = 1;
                        queue.offer(new Point(nx, ny, nz));
                        added++;
                    }
                }
            }

            // up, down
            for (int i = 0; i<2; i++) {
                int nx = now.x;
                int ny = now.y;
                int nz = now.z + dz[i];

                if (check(nx, ny, nz)) {
                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = 1;
                        queue.offer(new Point(nx, ny, nz));
                        added++;
                    }
                }
            }

            if (count == 0) {
                date++;
                count = added;
                added = 0;
            }
        }

        date--;

        System.out.println(allTomatoesRipen());

    }


    static int allTomatoesRipen() {
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if(map[z][x][y] == 0) return -1;
                }
            }
        }
        return date;
    }

    static boolean check(int x, int y, int z) {
        return x >= 0 && x < n && y >= 0 && y < m && z >= 0 && z < h;
    }


    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}