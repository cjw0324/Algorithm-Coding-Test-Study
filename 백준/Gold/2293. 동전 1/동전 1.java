import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] available;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        available = new int[k + 1];
        available[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int x = coin; x <= k; x++) {
                available[x] += available[x - coin];
            }
        }

        System.out.println(available[k]);
    }
}
