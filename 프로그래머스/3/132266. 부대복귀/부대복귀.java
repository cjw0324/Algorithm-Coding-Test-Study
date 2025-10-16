import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static int[] dist;
    static boolean[] visited;
    static int n;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        graph = new List[n + 1];
        for (int i = 0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int index = 0;
        int[] answer = new int[sources.length];
        int[] dist_to_all = bfs(destination);
        for (int i = 0; i<sources.length; i++) {
            answer[i] = dist_to_all[sources[i]];
        }
        return answer;
    }
    
    
    static int[] bfs(int start) {
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        visited = new boolean[n + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        dist[start] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    dist[next] = dist[now] + 1;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return dist;
    }
}