import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int m,n; //m : house, n : road
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                return;
            }

            pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int initPrice = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                initPrice += z;
                pq.offer(new Edge(x, y, z));
            }

            System.out.println(initPrice - Kruskal());
        }
    }

    static int Kruskal() {
        int totalCost = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int v1 = now.start;
            int v2 = now.end;
            int cost = now.cost;

            if (find(v1) != find(v2)) {
                union(v1, v2);
                totalCost += cost;
            }
        }
        return totalCost;
    }

    static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) return;

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    static int find(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }


    static class Edge {
        int start;
        int end;
        int cost;

        public Edge (int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }
    }
}