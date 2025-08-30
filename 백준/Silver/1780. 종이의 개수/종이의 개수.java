import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static int minus_one = 0;
    static int one = 0;
    static int zero = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N);

        System.out.println(minus_one);
        System.out.println(zero);
        System.out.println(one);
    }

    static void recursive(int x, int y, int n) {
        int mo = 0;
        int z = 0;
        int o = 0;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] == -1) {
                    mo++;
                } else if (board[i][j] == 1) {
                    o++;
                } else {
                    z++;
                }
            }
        }

        if (mo == n * n) {
            minus_one++;
        } else if (z == n * n) {
            zero++;
        } else if (o == n * n) {
            one++;
        } else {
            for (int i = x; i < x + n; i += n / 3) {
                for (int j = y; j < y + n; j += n / 3) {
                    recursive(i, j, n / 3);
                }
            }
        }

    }
}