import java.io.*;
import java.util.*;
public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        dp(n);
        System.out.println(memo[n]);
    }

    public static void dp(int n) {
        memo[0] = 0;
        if (n>0) memo[1] = 1;
        if (n>1) memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 15746;
        }
    }

}