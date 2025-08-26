import java.io.*;
import java.util.*;
public class Main {
    static int[] r;
    static int[] g;
    static int[] b;
    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        r = new int[n];
        g = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][3];

        dp[0][0] = r[0];
        dp[0][1] = g[0];
        dp[0][2] = b[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b[i];
        }

        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());

    }


}