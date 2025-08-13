import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];
        visited[0] = true;
        visited[1] = true;
        for (int i = 2; (long) i*i<=n; i++) {
            if (!visited[i]) {
                for (int p = i * i; p <= n; p = p + i) {
                    visited[p] = true;
                }
            }
        }

        for (int i = m; i<=n; i++) {
            if (!visited[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

}