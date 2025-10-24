//package template_baekjoon;

import java.io.*;
import java.util.*;
public class Main {
    static int[] dist;
    static boolean[] visited;
    static List<Edge>[] graph;
    static int n, e;
    static int INF = Integer.MAX_VALUE;
    static int v1, v2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int front1 = Dijkstra(1, v1);
        int front2 = Dijkstra(1, v2);

        int onetwo = Dijkstra(v1, v2);
        int twoone = Dijkstra(v2, v1);

        int back1 = Dijkstra(v2, n);
        int back2 = Dijkstra(v1, n);

        long total1 = (long) front1 + (long) onetwo + (long) back1;
        long total2 = (long) front2 + (long) twoone + (long) back2;

        if (total1 > total2) {
            if (front2 == INF || twoone == INF || back2 == INF) {
                System.out.println(-1);
                return;
            }
            System.out.println(total2);
        } else {
            if (front1 == INF || onetwo == INF || back1 == INF) {
                System.out.println(-1);
                return;
            }
            System.out.println(total1);
        }
    }

    static int Dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.e - e2.e);
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        visited = new boolean[n + 1];

        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;
            for (Edge next : graph[now.v]) {
                if (dist[next.v] > dist[now.v] + next.e) {
                    dist[next.v] = dist[now.v] + next.e;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
        return dist[end];
    }

    static class Edge {
        int v;
        int e;

        public Edge(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }
}
