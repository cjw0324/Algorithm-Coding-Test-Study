import java.io.*;
import java.util.*;
public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        memo = new int[n+2];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {

        if (memo[n] != -1) {
            return memo[n];
        } else {
            memo[n] = fibo(n-1) + fibo(n-2);
            return memo[n];
        }
    }
}