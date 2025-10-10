import java.io.*;
import java.util.*;
public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] nums = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= K; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int[] sums = new int[K + 1];
            for (int i = 1; i <= K; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
            int[][] dp = new int[K + 1][K + 1];
            for (int i = 1; i <= K; i++) {
                for (int from = 1; from + i <= K; from++) {
                    int to = from + i;
                    int min = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        min = Math.min(min, dp[from][divide] + dp[divide + 1][to]);
                    }
                    dp[from][to] = min + sums[to] - sums[from - 1];
                }
            }
            sb.append(dp[1][K]+"\n");
        }

        System.out.println(sb.toString().trim());
    }
}