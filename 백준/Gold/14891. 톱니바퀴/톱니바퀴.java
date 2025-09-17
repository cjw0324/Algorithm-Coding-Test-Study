
import java.io.*;
import java.util.*;

public class Main {
    static int[][] gear = new int[4][8];
    static int k;
    static int[][] moves;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(temp[j] + "");
            }
        }

        k = Integer.parseInt(br.readLine());
        moves = new int[k][2];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            moves[i][0] = Integer.parseInt(st.nextToken());
            moves[i][1] = Integer.parseInt(st.nextToken());
        }


        process();

        int x = 1;
        int answer = 0;
        for (int[] g : gear) {
            answer += x * g[0];
            x *= 2;
        }

        System.out.println(answer);


    }

    static void process() {
        for (int[] move : moves) {
            int n = move[0] - 1; // 인덱스 맞추기
            int dir = move[1];

            // 각 톱니의 회전 방향 기록
            int[] dirs = new int[4];
            dirs[n] = dir;

            // 왼쪽으로 전파
            for (int i = n - 1; i >= 0; i--) {
                if (gear[i][2] != gear[i + 1][6]) {
                    dirs[i] = -1 * dirs[i + 1];
                } else {
                    break;
                }
            }

            // 오른쪽으로 전파
            for (int i = n + 1; i < 4; i++) {
                if (gear[i - 1][2] != gear[i][6]) {
                    dirs[i] = -1 * dirs[i - 1];
                } else {
                    break;
                }
            }

            // 모든 톱니를 한꺼번에 회전 적용
            for (int i = 0; i < 4; i++) {
                if (dirs[i] != 0) {
                    move(gear[i], dirs[i]);
                }
            }
        }
    }


    static void move(int[] gear, int dis) { // 기어 회전
        if (dis == 1) {
            int before = gear[0];
            for (int i = 1; i < 8; i++) {
                int temp = gear[i];
                gear[i] = before;
                before = temp;
            }
            gear[0] = before;
            return;
        }
        if (dis == -1) {
            int before = gear[7];
            for (int i = 6; i >= 0; i--) {
                int temp = gear[i];
                gear[i] = before;
                before = temp;
            }
            gear[7] = before;
            return;
        }
    }
}