import java.io.*;
import java.util.*;


public class Main {
    static List<Edge>[] graph;
    static int n;
    static List<Integer> leaf;
    static int radius = 0;
    static class Edge {
        int n;
        int c;
        public Edge(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a, b, c;
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        leaf = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (graph[i].size() == 1) {
                leaf.add(i);
            }
        }

        for (int node : leaf) {
            boolean[] visited = new boolean[n + 1];
            visited[node] = true;
            dfs(visited, 0, node);
        }

        System.out.println(radius);
    }

    static void dfs(boolean[] visited, int sum, int start) {
        for (Edge edge : graph[start]) {
            if (!visited[edge.n]) {
                visited[edge.n] = true;
                dfs(visited, sum + edge.c, edge.n);
                visited[edge.n] = false;
            }
        }
        radius = Math.max(radius, sum);
    }
}