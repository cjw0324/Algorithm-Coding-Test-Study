import java.io.*;
import java.util.*;

public class Main {
    static long a, b, c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b, c));

    }

    static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long half = pow(a, b / 2, c);

        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return (((half * half) % c) * a) % c;
        }
    }
}