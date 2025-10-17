import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Edge> graph;
    static long[] dist;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.add(
                    new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        if (bellman_ford(1)) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(dist[i]+"\n");
            }
        }

        System.out.println(sb.toString().trim());

    }

    static boolean bellman_ford(int start) {
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 1; i <= n; i++) {
            for (Edge edge : graph) {
                int now = edge.v1;
                int next = edge.v2;
                int cost = edge.e;

                if ((dist[now] != Integer.MAX_VALUE) && (dist[next] > dist[now] + cost)) {
                    dist[next] = dist[now] + cost;

                    if (i == n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Edge {
        int v1;
        int v2;
        int e;

        public Edge(int v1, int v2, int e) {
            this.v1 = v1;
            this.v2 = v2;
            this.e = e;
        }
    }
}