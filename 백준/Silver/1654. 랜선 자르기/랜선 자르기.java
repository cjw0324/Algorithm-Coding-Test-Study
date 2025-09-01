import java.io.*;
import java.util.*;

public class Main {
    static int k, n;
    static int[] lines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lines = new int[k];

        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        Arrays.sort(lines);
        long shortest = lines[k-1];
        long left = 1;
        long right = shortest;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (cut(mid) < n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        System.out.println(answer);

    }

    static long cut(long length) {
        long c = 0;
        for (int i = 0; i < k; i++) {
            c += lines[i] / length;
        }
        return c;
    }
}