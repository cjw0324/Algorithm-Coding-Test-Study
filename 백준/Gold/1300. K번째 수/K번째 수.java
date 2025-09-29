import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Long.parseLong(br.readLine());

        long lt = 1;
        long rt = k;

        while (lt < rt) {
            long mid = (lt + rt) / 2;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (count >= k) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(lt);
    }
}