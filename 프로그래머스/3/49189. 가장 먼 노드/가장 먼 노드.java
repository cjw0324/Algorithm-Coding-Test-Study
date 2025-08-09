import java.util.*;
class Solution {
    static int[] distance;
    static boolean[] visited;
    public int solution(int n, int[][] edge) {
        distance = new int[n+1];
        visited = new boolean[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            //System.out.println("now : " + now);
            for (int[] vertex : edge) {
                int node1 = vertex[0];
                int node2 = vertex[1];
                
                if (now == node1 || now == node2) {
                    int next = (now == node1) ? node2 : node1;
                    if (!visited[next]) {
                        //System.out.println("next : " + next);

                        visited[next] = true;
                        queue.offer(next);
                        distance[next] = distance[now] + 1;
                        
                    }
                }
            }
        }
        int count = 0;
        int max = Arrays.stream(distance).max().getAsInt();
        for (int d : distance) {
            if (d == max) count++;
        }
        
        return count;
    }
}