import java.io.*;
import java.util.*;
public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int from = 0; from + i < n; from++) {
                int to = from + i;
                dp[from][to] = Integer.MAX_VALUE;
                for (int divide = from; divide < to; divide++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + matrix[from][0] * matrix[divide][1] * matrix[to][1]);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
