

import java.io.*;
import java.util.*;


public class Main {
    static long[] dist;
    static Edge[] graph;
    static int n, m;
    static StringBuilder sb;

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new Edge[m];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[i] = new Edge(a, b, c);
        }

        if (bellmanFord(1)) {
            sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.println(sb.toString().trim());
            return;
        }

        System.out.println("-1");


    }

    public static boolean bellmanFord(int start) {
        dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 1; i <= n; i++) {
            for (Edge edge : graph) {
                int now = edge.start;
                int next = edge.end;
                int cost = edge.cost;

                if (dist[now] != Integer.MAX_VALUE && dist[next] > dist[now] + cost) {
                    if (i == n) return false;

                    dist[next] = dist[now] + cost;
                }
            }
        }
        return true;
    }

}
