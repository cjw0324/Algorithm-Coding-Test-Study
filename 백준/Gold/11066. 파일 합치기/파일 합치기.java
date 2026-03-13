import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            for (int i = 1; i <= k; i++) {
                sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
            }

            for (int length = 2; length <= k; length++) {
                for (int start = 1; start <= k - length + 1; start++) {
                    int end = start + length - 1;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }
            sb.append(dp[1][k]).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
