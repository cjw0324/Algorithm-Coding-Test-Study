import java.util.*;
class Solution {

    public static void main(String[] args) {
        int s = new Solution().solution(5, new int[]{2, 3});
        System.out.println(s);
    }

    static final int mod = 1_000_000_007;

    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length][n + 1];
        Arrays.sort(money);

        for (int i = 0; i<money.length; i++) {
            for (int j = 0; j<=n; j++) {
                int m = money[i];
                if (i == 0) {
                    if (j % m != 0) {
                        continue;
                    }
                    dp[i][j] = 1;
                    continue;
                }
                if (j - m >= 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - m]) % mod;
                }
                else {
                    dp[i][j] = dp[i - 1][j] % mod;
                }
            }
        }
        
        return dp[money.length - 1][n];
    }
}