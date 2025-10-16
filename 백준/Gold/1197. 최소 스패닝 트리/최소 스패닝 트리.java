import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static StringBuilder sb = new StringBuilder();
    static int[] parent;
    static PriorityQueue<Edge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int weight = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }

        System.out.println(weight);
        
    }

    static class Edge {
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    public static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}