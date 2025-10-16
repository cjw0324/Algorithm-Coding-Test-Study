import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static int n;
    static long answer = 0;
    static boolean[] visited;
    static long[] temp;
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        n = a.length;
        graph = new List[n];
        visited = new boolean[n];
        temp = new long[n];
        for (int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
            temp[i] = (long)a[i];
            sum += temp[i];
        }
        
        if(sum != 0) return -1;
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        dfs(0);
        
        return answer;
        
    }
    
    static long dfs(int node) {
        visited[node] = true;
        for (int i = 0; i<graph[node].size(); i++) {
            int next = graph[node].get(i);
            if (!visited[next]) {
                temp[node] += dfs(next);
            }
        }
        answer += Math.abs(temp[node]);
        return temp[node];
    }
}
