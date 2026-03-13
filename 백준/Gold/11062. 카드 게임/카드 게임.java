import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] cards = new int[N];
            int[] prefix = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                prefix[i + 1] = prefix[i] + cards[i];
            }

            int[][] dp = new int[N][N];

            for (int len = 1; len <= N; len++) {
                for (int l = 0; l + len - 1 < N; l++) {
                    int r = l + len - 1;

                    if (l == r) {
                        dp[l][r] = cards[l];
                        continue;
                    }

                    int total = prefix[r + 1] - prefix[l];

                    dp[l][r] = Math.max(
                            total - dp[l + 1][r],
                            total - dp[l][r - 1]
                    );
                }
            }

            sb.append(dp[0][N - 1]).append('\n');
        }

        System.out.print(sb);
    }
}