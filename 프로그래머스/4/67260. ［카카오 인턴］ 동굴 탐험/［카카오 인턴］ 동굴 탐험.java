import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[] need;
    static int[] waiting;
    public boolean solution(int n, int[][] path, int[][] order) {
        graph = new List[n];
        visited = new boolean[n];
        need = new int[n];
        waiting = new int[n];
        for (int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : path) {
            graph[p[0]].add(p[1]);
            graph[p[1]].add(p[0]);
        }
        
        Arrays.fill(need, -1);
        Arrays.fill(waiting, -1);
        for (int[] o : order) {
            int a = o[0];
            int b = o[1];
            need[b] = a;
        }
        
        if (need[0] != -1) return false;
        
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (waiting[now] != -1) {
                int unlock = waiting[now];
                if (!visited[unlock]) {
                    visited[unlock] = true;
                    queue.offer(unlock);
                }
                
                waiting[now] = -1;
            }
            
            
            for (int next : graph[now]) {
                if (visited[next]) continue;
                
                if (need[next] == -1 || visited[need[next]]) {
                    visited[next] = true;
                    queue.offer(next);
                } else {
                    waiting[need[next]] = next;
                }
                
            }
        }
        
        for (boolean b : visited) {
            if(!b) return false;
        }
        return true;
    }
    
}