import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] price = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        int p = 0;
        for (int i = 0; i < n - 1; i++) {
            int nextDistance = dist[i];
            int nowPrice = price[i];
            if (i == 0) {
                p = nowPrice;
            } else {
                if (p > nowPrice) {
                    p = nowPrice;
                }
            }
            sum += (long) p * (long) nextDistance;
        }

        System.out.println(sum);
    }
}