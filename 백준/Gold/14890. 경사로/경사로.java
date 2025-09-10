import java.io.*;
import java.util.*;
public class Main {
    static int n, l;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            if (row(i)) count++;
            if ((col(i))) count++;
        }

        System.out.println(count);
    }

    static boolean row(int r) {
        boolean[] made = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[r][i] - map[r][i + 1];
            if (Math.abs(diff) > 1) {
                return false;
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if ( i + j >= n || made[i + j]) return false;
                    if (map[r][i] - 1 != map[r][i + j]) return false;
                    made[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || made[i - j]) return false;
                    if (map[r][i] != map[r][i - j]) return false;
                    made[i - j] = true;
                }
            }
        }

        return true;
    }

    static boolean col(int c) {
        boolean[] made = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][c] - map[i + 1][c];
            if (Math.abs(diff) > 1) {
                return false;
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || made[i + j]) return false;
                    if (map[i][c] - 1 != map[i + j][c]) return false;
                    made[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || made[i - j]) return false;
                    if (map[i][c] != map[i - j][c]) return false;
                    made[i - j] = true;
                }
            }
        }
        return true;
    }
}