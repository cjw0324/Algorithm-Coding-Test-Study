import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visitable;
    public boolean solution(int n, int[][] path, int[][] order) {
        visitable = new boolean[n];
        
        Arrays.fill(visitable, true);
        
        for (int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] connection : path) {
            int node1 = connection[0];
            int node2 = connection[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        for (int[] o : order) {
            map.put(o[0], o[1]);
            visitable[o[1]] = false;
        }
        
        if(!visitable[0]) return false;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        visited[0] = true;
        queue.offer(0);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : graph.get(now)) {
                if (!visited[next] && visitable[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            
            Integer open = map.get(now);
            if (open != null){
                visitable[open] = true;
                for (int before : graph.get(open)) {
                    if (visited[before]) {
                        visited[open] = true;
                        queue.offer(open);
                        break;
                    }
                }
            }
        }
        
        
        for (boolean check : visited) {
            if (!check) return false;
        }
        return true;
        
        
    }
    
}