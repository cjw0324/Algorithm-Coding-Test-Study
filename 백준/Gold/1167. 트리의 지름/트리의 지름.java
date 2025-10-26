import java.io.*;
import java.util.*;

public class Main {
    static int v;
    static boolean[] visited;
    static int maxDist = Integer.MIN_VALUE;
    static int farNode = 0;
    static List<Edge>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph[from].add(new Edge(to, cost));
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static class Edge {
        int to;
        int cost;

        public Edge (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }

        for (Edge e : graph[node]) {
            if (!visited[e.to]) {
                dfs(e.to, dist + e.cost);
            }
        }
    }
}
