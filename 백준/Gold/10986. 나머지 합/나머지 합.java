import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n + 1];
        int[] remain = new int[m];

        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                remain[i]++;
                continue;
            }
            sum[i] = (sum[i - 1] + Long.parseLong(st.nextToken())) % m;
            remain[(int) sum[i]]++;
        }


        long count = 0;
        for (int i = 0; i < m; i++) {
            count += (long) remain[i] * ( (long) remain[i] - 1) / 2;
        }

        System.out.println(count);
    }
}