import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[11];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=10; i++) {
            dp[i] = i * dp[i-1];
        }

        System.out.println(dp[n] / (dp[k] * dp[n-k]));
    }


}