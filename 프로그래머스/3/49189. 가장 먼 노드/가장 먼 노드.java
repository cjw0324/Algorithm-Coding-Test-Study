import java.util.*;
class Solution { //가중치가 없어서, bfs로 품
    static int[] distance;
    static int[][] edges;
    public int solution(int n, int[][] edge) {
        distance = new int[n];
        this.edges = edge.clone();
        bfs();
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        int i = 1;
        for (int d : distance) {
            //System.out.println("node" + i + ": " + d);
            if (d > max) {
                count = 1;
                max = d;
            } else if (d == max) {
                count++;
            }
            i++;
        }
        
        return count;
    }
    
    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        distance[0] = 1;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] edge : edges) {
                if (edge[0] == node || edge[1] == node) {
                    //System.out.println("edge[0] : " + edge[0] +", edge[1] : " + edge[1] +", node : " + node);
                    int next = edge[0]==node?edge[1]:edge[0];
                    if (distance[next - 1] == 0) {
                        distance[next - 1] = distance[node - 1] + 1;
                        //System.out.println("next : " + next +", distance[" +next+"] : " + distance[next - 1]);
                        queue.offer(next);
                    }
                }
            }
        }
    }
}