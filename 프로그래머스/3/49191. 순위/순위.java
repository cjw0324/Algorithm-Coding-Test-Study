import java.util.*;
class Solution {
    static int n;
    public int solution(int n, int[][] results) {
        int answer = 0;
        this.n = n;
        for (int i = 0; i<n; i++){
            int win = win(i+1, results);
            int lose = lose(i+1, results);
            System.out.println( (i+1)+"player's win count : " + win);
            System.out.println( (i+1)+"player's lose count : " + lose);
            
            if (win + lose == n - 1) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    
    public int win(int start,int[][] results) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start - 1] = true;
        int count = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll(); //1,2,3,4,5
            for (int[] result : results) {
                if (result[0] == now && !visited[result[1] - 1]) {
                    int next = result[1];
                    visited[next - 1] = true;
                    queue.offer(next);
                    count++;
                }
            }    
        }
        return count;
    }
    
    public int lose(int start, int[][] results) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start - 1] = true;
        int count = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll(); //1,2,3,4,5
            for (int[] result : results) {
                if (result[1] == now && !visited[result[0] - 1]) {
                    int next = result[0];
                    visited[next - 1] = true;
                    queue.offer(next);
                    count++;
                }
            }    
        }
        return count;
    }
}