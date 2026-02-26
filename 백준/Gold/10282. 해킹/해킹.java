

import java.io.*;
import java.util.*;


public class Main {
    static int T;
    static int n, d, c;
    static PriorityQueue<Edge> pq;
    static List<Edge>[] graph;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;
    static int maxTime, count;
    static class Edge {
        int node;
        int time;

        public Edge(int n, int t) {
            this.node = n;
            this.time = t;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new List[n + 1];

            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int demand = 0; demand < d; demand++) {
                st = new StringTokenizer(br.readLine(), " ");
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                graph[start].add(new Edge(end, time));
            }


            dijkstra();
            sb.append(count + " " + maxTime).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dijkstra() {
        maxTime = 0;
        count = 0;
        pq = new PriorityQueue<>((e1, e2) -> e1.time - e2.time);
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        dist[c] = 0;
        pq.offer(new Edge(c, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.node]) continue;
            visited[now.node] = true;
            count++;
            maxTime = Math.max(maxTime, now.time);
            for (Edge next : graph[now.node]) {
                if (!visited[next.node] && dist[next.node] > dist[now.node] + next.time) {
                    dist[next.node] = dist[now.node] + next.time;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }
    }

}
