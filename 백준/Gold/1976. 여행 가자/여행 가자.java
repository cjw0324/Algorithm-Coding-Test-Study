import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1 || i == j) {
                    union(i, j);
                }
            }
        }


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int head = find(Integer.parseInt(st.nextToken()) - 1);
        for (int i = 1; i < m; i++) {
            if (head != find(Integer.parseInt(st.nextToken()) - 1)) {
                    System.out.println("NO");
                    return;
                }

        }

        System.out.println("YES");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}