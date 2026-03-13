import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][2];
        dp = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }


        if (n == 1) {
            System.out.println(0);
            return;
        }
        for (int gap = 1; gap < n; gap++) {
            for (int start = 0; start + gap < n; start++) {
                int end = start + gap;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid < end; mid++) {
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + matrix[start][0] * matrix[mid][1] * matrix[end][1]);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
