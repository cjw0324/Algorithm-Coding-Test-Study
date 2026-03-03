import java.io.*;
import java.util.*;

/**
 * BOJ 2629 (양팔저울) - 정석 DP
 *
 * dp[i][d] = i번째 추까지 사용했을 때, 무게 차이 d를 만들 수 있는가?
 * (차이 d는 |왼쪽 - 오른쪽| 로 정의)
 *
 * 전이 (i번째 추 무게 w):
 * 1) 추를 사용하지 않음:          dp[i+1][d] = true
 * 2) 더 무거운 쪽에 올림:          dp[i+1][d + w] = true
 * 3) 더 가벼운 쪽에 올림(차이 감소): dp[i+1][|d - w|] = true
 */
public class Main {
    static final int MAX_D = 15000; // 추 무게 합 최대 (30 * 500)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] w = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            sum += w[i];
        }

        // dp[i][d] : i개 추 사용(0..n), 차이 d(0..sum) 가능 여부
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            int weight = w[i];
            for (int d = 0; d <= sum; d++) {
                if (!dp[i][d]) continue;

                // 1) 사용 안 함
                dp[i + 1][d] = true;

                // 2) 더 무거운 쪽에 올림 -> 차이 증가
                if (d + weight <= sum) dp[i + 1][d + weight] = true;

                // 3) 더 가벼운 쪽에 올림 -> 차이 감소 (절댓값)
                int nd = Math.abs(d - weight);
                dp[i + 1][nd] = true;
            }
        }

        int m = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            // 구슬이 sum보다 무거우면 절대 불가능
            if (x > sum) sb.append("N ");
            else sb.append(dp[n][x] ? "Y " : "N ");
        }

        System.out.print(sb.toString());
    }
}