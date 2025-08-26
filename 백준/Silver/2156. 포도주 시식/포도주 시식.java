import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] dp;
    static int[] wine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }

        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        if (n == 2) {
            System.out.println(wine[1] + wine[2]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + wine[i - 1] + wine[i], Math.max(dp[i - 2] + wine[i], dp[i - 1]));
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}