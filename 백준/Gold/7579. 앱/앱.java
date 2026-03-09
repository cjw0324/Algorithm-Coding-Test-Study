
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n];
        int[] cost = new int[n];

        StringTokenizer memoryLine = new StringTokenizer(br.readLine());
        StringTokenizer costLine = new StringTokenizer(br.readLine());
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(memoryLine.nextToken());
            cost[i] = Integer.parseInt(costLine.nextToken());
            totalCost += cost[i];
        }

        int[] dp = new int[totalCost + 1];

        for (int i = 0; i < n; i++) {
            for (int j = totalCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int j = 0; j <= totalCost; j++) {
            if (dp[j] >= m) {
                System.out.println(j);
                return;
            }
        }
    }
}
