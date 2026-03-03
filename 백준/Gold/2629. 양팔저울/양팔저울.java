import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        int[] chu = new int[n];

        st = new StringTokenizer(br.readLine());
        int chuMax = 0;
        for (int i = 0; i < n; i++) {
            chu[i] = Integer.parseInt(st.nextToken());
            chuMax += chu[i];
        }

        boolean[] dy = new boolean[40001];
        dy[0] = true;

        for (int i = 0; i < n; i++) {
            int w = chu[i];

            // dy[j]가 true인 상태에서 dy[j+w] 갱신 (j는 큰 값부터 내려가야 중복 사용 방지)
            for (int j = chuMax; j >= 0; j--) {
                if (dy[j] && j + w <= 40000) dy[j + w] = true;
            }

            // dy[j]가 true인 상태에서 dy[|j-w|] 갱신 (여긴 오름차순으로 그대로)
            for (int j = 0; j <= chuMax; j++) {
                if (dy[j]) dy[Math.abs(j - w)] = true;
            }
        }

        int m = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(dy[tmp] ? "Y " : "N ");
        }

        System.out.print(sb.toString());
    }
}