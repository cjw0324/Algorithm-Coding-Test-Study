import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;

    static int blue = 0;
    static int white = 0;
    static int N;
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
        System.out.println(white);
        System.out.println(blue);
    }


    static void recursive(int x, int y, int n) {
        int sum = 0;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                sum += board[i][j];
            }
        }

        if (sum == 0) {
            white++;
            return;
        }
        if (sum == n * n) {
            blue++;
            return;
        }
        int boundary = n;
        n = n / 2;
        for (int i = x; i < x + boundary; i+= n) {
            for (int j = y; j < y + boundary; j += n) {
                recursive(i, j, n);
            }
        }
    }
}