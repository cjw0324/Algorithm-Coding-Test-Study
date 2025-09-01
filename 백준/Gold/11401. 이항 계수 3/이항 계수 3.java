import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int big = 1_000_000_007;
    static long[] fact;
    static long[] reverseFact;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fact = new long[n + 1];
        reverseFact = new long[n + 1];

        init(n);
        long answer = (fact[n] * reverseFact[k] % big) * reverseFact[n - k] % big;
        System.out.println(answer);
    }

    static void init(int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % big;
        }

        reverseFact[n] = pow(fact[n], big - 2);

        for (int i = n - 1; i >= 0; i--) {
            reverseFact[i] = (reverseFact[i + 1] * (i + 1)) % big;
        }
    }

    static long pow(long a, long b) {
        if (b == 0) return 1;
        long half = pow(a, b / 2);
        if (b % 2 == 0) {
            return (half * half) % big;
        }
        return (((half * half) % big) * a) % big;
    }

}