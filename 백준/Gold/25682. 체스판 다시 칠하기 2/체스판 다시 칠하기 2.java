import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ps = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                char c = row[j - 1];
                char needed;
                if ((i + j) % 2 == 0) {
                    needed = 'B';
                } else {
                    needed = 'W';
                }
                int change = 0;
                if (c != needed) {
                    change = 1;
                }
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + change;
            }
        }

        int answer = Integer.MAX_VALUE;

        int total = K * K;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int black = ps[i][j] - ps[i - K][j] - ps[i][j - K] + ps[i - K][j - K];
                int white = total - black;
                answer = Math.min(answer, Math.min(black, white));
            }
        }

        System.out.println(answer);
    }
}