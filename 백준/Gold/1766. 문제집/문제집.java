import java.util.*;
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] degree;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        degree = new int[n+1];
        
        for (int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i<m; i++){
            int first = kb.nextInt();
            int second = kb.nextInt();
            
            graph.get(first).add(second);
            degree[second]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i<=n; i++) {
            if (degree[i] == 0) {
                pq.offer(i);    
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");
            for (int next : graph.get(now)) {
                degree[next]--;
                if (degree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}