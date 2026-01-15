import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int start;
    static List<Edge> graph;
    static StringTokenizer st;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = 1;
        graph = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            graph.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        if (bellmanFord()) {
            sb.append(-1);
            System.out.println(sb.toString().trim());
            return;
        }

        for (int i = 2; i <= N; i++) {
            sb.append(dist[i] == Long.MAX_VALUE ? "-1\n" : dist[i] + "\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static boolean bellmanFord() {
        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i <= N; i++) {
            for (Edge edge : graph) {
                int from = edge.v1;
                int to = edge.v2;
                int cost = edge.c;

                if (dist[from] != Long.MAX_VALUE && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;

                    if (i == N) {
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
        int c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}
