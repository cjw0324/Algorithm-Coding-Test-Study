import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] dp;
    static int[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        input = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = input[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + input[i][0];
            dp[i][i] = dp[i - 1][i - 1] + input[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + input[i][j];
            }
        }

        System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());

    }


}