import java.io.*;
import java.util.*;
public class Main {
    static long[] memo = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (t == 0) {
            return;
        }
        dp();

        for (int i : arr) {
            System.out.println(memo[i]);
        }
    }

    public static void dp() {
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;

        for (int i = 5; i <= 100; i++) {
            memo[i] = memo[i - 5] + memo[i - 1];
        }
    }
}