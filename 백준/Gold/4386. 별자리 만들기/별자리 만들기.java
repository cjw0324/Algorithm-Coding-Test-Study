import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main {
    static Point[] stars;
    static int n;
    static int[] parent;
    static double totalCost = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stars = new Point[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            stars[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.cost < e2.cost) return -1;
            return 1;
        });

        for (int i = 0; i<n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point start = stars[i];
                Point end = stars[j];

                double dist = Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
                pq.offer(new Edge(i, j, dist));
            }
        }

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.start) == find(edge.end)) continue;

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

    static class Point {
        double x;
        double y;
        public Point (double x, double y) {
            this.x = x;
            this.y = y;
        }
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
