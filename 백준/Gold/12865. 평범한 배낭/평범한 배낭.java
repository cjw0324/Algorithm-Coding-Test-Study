import java.io.*;
import java.util.*;
public class Main {
    static int n, k;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];

        int[][] items = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i][0] = w;
            items[i][1] = v;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int w = items[i][0];
                int v = items[i][1];

                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }

        }

        System.out.println(dp[n][k]);
    }
}
