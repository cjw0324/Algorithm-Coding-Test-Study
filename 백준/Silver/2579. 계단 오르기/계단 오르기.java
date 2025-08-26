import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] dp;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        score = new int[n + 1];
        dp = new int[n + 1];
        score[0] = 0;
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(score[n]);
            return;
        }

        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        if (n == 2) {
            System.out.println(dp[n]);
            return;
        }


        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
