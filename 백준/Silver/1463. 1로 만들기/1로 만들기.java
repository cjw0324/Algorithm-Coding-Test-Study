import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            int first = i + 1;
            int second = i * 2;
            int third = i * 3;
            int count = dp[i];
            if (first <= n) {
                dp[first] = Math.min(dp[first], count + 1);
            }
            if (second <= n) {
                dp[second] = Math.min(dp[second], count + 1);
            }
            if (third <= n) {
                dp[third] = Math.min(dp[third], count + 1);
            }
        }

        System.out.println(dp[n]);
    }
}