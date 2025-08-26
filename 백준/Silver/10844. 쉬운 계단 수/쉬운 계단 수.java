import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static long[] dp;
    static long big = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[10];
        Arrays.fill(dp, 1);
        dp[0] = 0;

        for (int i = 2; i <= n; i++) {
            long[] next = new long[10];
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    next[j] = dp[1] % big;
                } else if (j == 9) {
                    next[j] = dp[8] % big;
                } else {
                    next[j] = (dp[j + 1]  % big) + (dp[j - 1] % big);
                }
            }
            dp = next;
        }


        System.out.println(Arrays.stream(dp).sum() % big);
    }
}