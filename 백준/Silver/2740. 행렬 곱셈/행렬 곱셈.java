import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k;
    static int[][] a;
    static int[][] b;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        b = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[n][k];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < k; y++) {
                for (int k = 0; k < m; k++) {
                    answer[x][y] += a[x][k] * b[k][y];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.toString().trim();
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}