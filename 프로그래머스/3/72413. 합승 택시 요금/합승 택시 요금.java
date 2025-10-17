import java.util.*;
class Solution {
    static int n, s, a, b;
    static List<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        this.s = s;
        this.a = a;
        this.b = b;
        
        graph = new List[n + 1];
        for (int i = 0; i<= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            graph[fare[0]].add(new Edge(fare[1], fare[2]));
            graph[fare[1]].add(new Edge(fare[0], fare[2]));
        }
        
        int[] s_to_n = Dijkstra(s);
        int[] a_to_n = Dijkstra(a);
        int[] b_to_n = Dijkstra(b);
        
        
        int min = INF;
        for (int i = 1; i<=n; i++) {
            min = Math.min(min, s_to_n[i] + a_to_n[i] + b_to_n[i] );
        }
        
        return min;
        
    }
    
    static class Edge {
        int v;
        int e;
        
        public Edge(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }
    
    
    static int[] Dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.e - e2.e);
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            int now = edge.v;
            
            if (visited[now]) continue;
            visited[now] = true;
            
            for (Edge next : graph[now]) {
                if (!visited[next.v] && dist[next.v] > dist[now] + next.e) {
                    dist[next.v] = dist[now] + next.e;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
        
        return dist;
    }
}