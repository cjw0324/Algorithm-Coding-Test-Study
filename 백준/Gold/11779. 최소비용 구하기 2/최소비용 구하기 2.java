import java.io.*;
import java.lang.annotation.ElementType;
import java.util.*;
import javax.xml.stream.events.EndDocument;

public class Main {
    static int n, m;
    static PriorityQueue<Edge> edges;
    static List<Edge>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    static List<Integer>[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        route = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = INF;
            graph[i] = new ArrayList<>();
            route[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(Dijkstra(s, e)).append("\n");

        sb.append(route[e].size()).append("\n");
        for (int n : route[e]) {
            sb.append(n + " ");
        }

        System.out.println(sb.toString().trim());
    }

    static int Dijkstra(int start, int end) {
        dist[start] = 0;
        route[start].add(start);
        edges.offer(new Edge(start, 0));
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            int now = e.node;

            if (visited[now]) continue;
            visited[now] = true;

            for (Edge next : graph[now]) {
                if (!visited[next.node] && dist[next.node] > dist[now] + next.cost) {
                    dist[next.node] = dist[now] + next.cost;
                    List<Integer> beforeRoute = route[now];
                    route[next.node] = new ArrayList<>();
                    for (int r : beforeRoute) {
                        route[next.node].add(r);
                    }
                    route[next.node].add(next.node);

                    edges.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }
        return dist[end];
    }

    static class Edge {
        int node;
        int cost;

        public Edge(int n, int c) {
            this.node = n;
            this.cost = c;
        }
    }
}