import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(str[j]);
            }
        }

        recursive(0, 0, N);

        System.out.println(sb);
    }

    static void recursive(int x, int y, int n) {
        int sum = 0;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                sum += board[i][j];
            }
        }

        if (sum == 0) {
            sb.append(0);
        } else if (sum == n * n) {
            sb.append(1);
        } else {
            sb.append("(");
            for (int i = x; i < x + n; i += n / 2) {
                for (int j = y; j < y + n; j += n / 2) {
                    recursive(i, j, n / 2);
                }
            }
            sb.append(")");
        }

    }
}