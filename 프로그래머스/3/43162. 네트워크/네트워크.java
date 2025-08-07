import java.util.*;
class Solution {
    static boolean[] visited;
    static int n;
    static int[][] computers;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.n = n;
        this.computers = computers.clone();
        int answer = 0;
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                answer += BFS(i);
            }
        }
        
        return answer;
    }
    
    
    public int BFS(int node) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i<n; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    int next = i;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return 1;
    }
}