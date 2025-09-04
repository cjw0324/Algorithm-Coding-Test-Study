

import java.io.*;
import java.util.*;
public class Main {
    static int n,m,x,y,k;
    static int[][] map;
    static int[] order;
    static StringBuilder sb = new StringBuilder();
    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken());
            int[] temp = availableCommand(command);
            if (temp[0] == 1) {
                x = temp[1];
                y = temp[2];

                rolling(command);

                int board = map[x][y];
                int diceBottom = dice[5];
                int diceTop = dice[0];

                sb.append(diceTop).append("\n");

                if (board == 0) {
                    map[x][y] = diceBottom;
                } else {
                    dice[5] = board;
                    map[x][y] = 0;
                }
            }
        }

        System.out.println(sb);

    }


    static void rolling(int div) {
        int[] before = dice.clone();
        if (div == 1) {
            dice[0] = before[3];
            dice[1] = before[1];
            dice[2] = before[0];
            dice[3] = before[5];
            dice[4] = before[4];
            dice[5] = before[2];
        } else if (div == 2) {
            dice[0] = before[2];
            dice[1] = before[1];
            dice[2] = before[5];
            dice[3] = before[0];
            dice[4] = before[4];
            dice[5] = before[3];
        } else if (div == 3) {
            dice[0] = before[4];
            dice[1] = before[0];
            dice[2] = before[2];
            dice[3] = before[3];
            dice[4] = before[5];
            dice[5] = before[1];
        } else {
            dice[0] = before[1];
            dice[1] = before[5];
            dice[2] = before[2];
            dice[3] = before[3];
            dice[4] = before[0];
            dice[5] = before[4];
        }
    }


    static int[] availableCommand(int command) {
        int nx = x;
        int ny = y;
        if (command == 1) {
            ny += 1;
        } else if (command == 2) {
            ny -= 1;
        } else if (command == 3) {
            nx -= 1;
        } else {
            nx += 1;
        }

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return new int[]{0,x, y};
        }
        return new int[]{1,nx, ny};
    }
}

