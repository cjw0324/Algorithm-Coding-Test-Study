import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main {
    static int n, m;
    static Point[] points;
    static int[] parent;
    static PriorityQueue<Edge> pq;
    static double totalCost = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        points = new Point[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }


        pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.cost < e2.cost) return -1;
            else return 1;
        });


        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double dist =
                        Math.sqrt(Math.pow(points[i].x - points[j].x, 2) +
                                Math.pow(points[i].y - points[j].y, 2));
                pq.offer(new Edge(i, j, dist));
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.start) == find(edge.end)) {
                continue;
            }

            union(edge.start, edge.end);
            totalCost += edge.cost;
        }

        System.out.println(String.format("%.2f", totalCost));


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

    static class Edge {
        int start;
        int end;
        double cost;

        public Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }


}
