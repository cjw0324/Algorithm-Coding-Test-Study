import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static PriorityQueue<Edge> graph;
    static StringTokenizer st;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Edge(start, end, cost));
        }

        int answer = Kruskal();
        System.out.println(answer);
    }

    static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) return;

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

    static int Kruskal() {
        //graph = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        int totalCost = 0;
        int max = Integer.MIN_VALUE;
        while (!graph.isEmpty()) {
            Edge now = graph.poll();
            int start = now.start;
            int end = now.end;
            int cost = now.cost;
            if (find(start) != find(end)) {
                union(start, end);
                totalCost += cost;
                max = Math.max(cost, max);
            }
        }

        return totalCost - max;
    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}