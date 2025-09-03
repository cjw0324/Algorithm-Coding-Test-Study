

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, -1, 0, 0};   // 아래, 위, 왼, 오 (사용자 코드 유지)
    static int[] dy = {0, 0, -1, 1};
    static int holeX, holeY;
    static Boll bolls;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][n][m];
        bolls = new Boll(0, 0, 0, 0, 0);

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
                if (line[j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if (line[j] == 'B') {
                    bolls.bx = i;
                    bolls.by = j;
                    map[i][j] = '.'; // B, R는 빈칸으로 치환 (굴림 로직 단순화)
                } else if (line[j] == 'R') {
                    bolls.rx = i;
                    bolls.ry = j;
                    map[i][j] = '.';
                }
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Queue<Boll> queue = new LinkedList<>();
        queue.add(bolls);
        visited[bolls.rx][bolls.ry][bolls.bx][bolls.by] = true;

        while (!queue.isEmpty()) {
            Boll boll = queue.poll();
            int nowRx = boll.rx;
            int nowRy = boll.ry;
            int nowBx = boll.bx;
            int nowBy = boll.by;
            int nowCount = boll.count;

            // 10회 초과 이동은 확장 중단 (즉시 실패 리턴 X)
            if (nowCount >= 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextRx = nowRx;
                int nextRy = nowRy;
                int nextBx = nowBx;
                int nextBy = nowBy;

                boolean redGoal = false;
                boolean blueGoal = false;

                int rDist = 0;
                int bDist = 0;

                // 빨간 구슬 굴리기 (경계/벽 체크 먼저 → OOB 방지)
                while (true) {
                    int nx = nextRx + dx[i];
                    int ny = nextRy + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if (map[nx][ny] == '#') break;
                    nextRx = nx;
                    nextRy = ny;
                    rDist++;
                    if (nextRx == holeX && nextRy == holeY) {
                        redGoal = true;
                        break;
                    }
                }

                // 파란 구슬 굴리기
                while (true) {
                    int nx = nextBx + dx[i];
                    int ny = nextBy + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if (map[nx][ny] == '#') break;
                    nextBx = nx;
                    nextBy = ny;
                    bDist++;
                    if (nextBx == holeX && nextBy == holeY) {
                        blueGoal = true;
                        break;
                    }
                }

                // 파란 구슬 빠지면 무효
                if (blueGoal) continue;

                // 빨간 구슬만 빠지면 성공
                if (redGoal) return nowCount + 1;

                // 두 구슬이 같은 칸이면 더 많이 이동한 쪽을 한 칸 되돌림
                if (nextRx == nextBx && nextRy == nextBy) {
                    if (rDist > bDist) {
                        nextRx -= dx[i];
                        nextRy -= dy[i];
                    } else {
                        nextBx -= dx[i];
                        nextBy -= dy[i];
                    }
                }

                if (!visited[nextRx][nextRy][nextBx][nextBy]) {
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.offer(new Boll(nextRx, nextRy, nextBx, nextBy, nowCount + 1));
                }
            }
        }
        return -1;
    }

    public static class Boll {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        public Boll(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
}
