import java.util.*;
class Solution {
    static List<Node>[] graph;
    static int[] dist;
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        graph = new List[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 0; i<=N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] edge : road) {
            graph[edge[0]].add(new Node(edge[1], edge[2]));
            graph[edge[1]].add(new Node(edge[0], edge[2]));
        }
        
        dijkstra(1);
        
        int answer = 0;
        for (int d : dist) {
            if (d <= K) answer++;
        }
        
        return answer;
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new Node(1, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (!visited[now.node]) {
                visited[now.node] = true;
            }
            
            for (Node next : graph[now.node]) {
                if (!visited[next.node] && dist[next.node] > dist[now.node] + next.cost) {
                    dist[next.node] = dist[now.node] + next.cost;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
    
    
    static class Node {
        int node;
        int cost;
        
        public Node(int n, int c) {
            this.node = n;
            this.cost = c;
        }
    }
}