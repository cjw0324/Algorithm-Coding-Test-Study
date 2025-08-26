import java.io.*;
import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] up = new int[n + 2];
        up[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    max = Math.max(max, up[j]);
                }
            }
            up[i] = max + 1;
        }

        int[] down = new int[n + 2];
        down[n] = 1;
        for (int i = n - 1; i >= 1; i--) {
            int max = 0;
            for (int j = i + 1; j <= n + 1; j++) {
                if (num[j] < num[i]) {
                    max = Math.max(down[j], max);
                }
            }
            down[i] = max + 1;
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, up[i] + down[i]);
        }

        System.out.println(answer - 1);

    }
}