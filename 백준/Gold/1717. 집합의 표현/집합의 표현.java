import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(x, y);
            } else {
                sb.append(find(x) == find(y) ? "yes\n" : "no\n");
            }
        }

        System.out.println(sb.toString().trim());
    }


    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return;
        }
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
}