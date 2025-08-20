import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(0);
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int d : arr) {
                sb.append(d).append(" ");
            }
            sb.append("\n");
        }

        else {
            for (int i = 1; i<=n; i++) {
                arr[depth] = i;
                dfs(depth+ 1);
            }
        }
    }
}