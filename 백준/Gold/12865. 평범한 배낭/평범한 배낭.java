import java.io.*;
import java.util.*;
public class Main {
    static int[] v;
    static int[] w;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        v = new int[n];
        w = new int[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }


        dp = new int[n][k + 1];

        for (int j = 0; j <= k; j++) {
            if (w[0] <= j) {
                dp[0][j] = v[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[dp.length - 1][k]);
    }
}