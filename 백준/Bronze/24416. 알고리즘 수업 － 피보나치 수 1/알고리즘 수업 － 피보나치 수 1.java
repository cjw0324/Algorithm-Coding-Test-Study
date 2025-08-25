import java.io.*;
import java.util.*;
public class Main {
    static int count1, count2 = 0;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        recall(n);
        dp(n);

        System.out.println(count1 + " " + count2);
    }

    public static int recall(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        return recall(n-1) + recall(n - 2);
    }

    public static int dp(int n) {
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            count2++;
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}