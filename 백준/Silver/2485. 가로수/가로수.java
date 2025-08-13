
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i<n;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        long[] distance = new long[n-1];
        long total = 0;
        for (int i = 0; i<n - 1; i++) {
            distance[i] = arr[i + 1] - arr[i];
            total += distance[i];
        }
        long GCD = gcdAll(distance);
        int answer = 0;

        for (long d : distance) {
            answer += (d / GCD) - 1;
        }

        System.out.println(answer);
    }

    static long gcdAll(long[] arr) {
        long g = 0;
        for (long next : arr) {
            g = gcd(g, next);
        }
        return g;
    }

    static long gcd(long a, long b) {
        while(b!=0) {
            long t = a%b;
            a = b;
            b = t;
        }
        return a;
    }

}