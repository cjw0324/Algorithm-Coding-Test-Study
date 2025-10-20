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

        parent = new int[n];
        for (int i = 0; i<n; i++) {
            parent[i] = i;
        }

        int count = 1;

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(cycle(n1, n2)) {
                System.out.println(count);
                return;
            }
            union(n1, n2);

            count++;
        }
        br.close();
        System.out.println(0);
    }

    static boolean cycle(int n1, int n2) {
        return find(n1) == find(n2);
    }

    static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    static int find(int n) {
        if (n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }

}