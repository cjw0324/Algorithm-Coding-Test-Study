import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken()) - 1;
            int j1 = Integer.parseInt(st.nextToken()) - 1;
            int i2 = Integer.parseInt(st.nextToken()) - 1;
            int j2 = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            for (int x = i1; x <= i2; x++) {
                if (j1 == 0) {
                    sum += map[x][j2];
                } else {
                    sum += (map[x][j2] - map[x][j1 - 1]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
