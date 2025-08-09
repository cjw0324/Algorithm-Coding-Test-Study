import java.util.*;
class Solution {
    static int ticketCount;
    static List<String> answer = new ArrayList<>();
    static boolean[] used;
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        ticketCount = tickets.length;
        
        dfs("ICN", 0, tickets, "ICN");
        
        Collections.sort(answer);
        
        String[] arr = answer.get(0).split(" ");
        
        return arr;
        
    }
    
    public void dfs(String now, int depth, String[][] tickets, String path) {
        if (depth == tickets.length) {
            answer.add(path);
            return;
        }
        for (int i = 0; i<tickets.length; i++){
            if (tickets[i][0].equals(now) && !used[i]){
                used[i] = true;
                dfs(tickets[i][1], depth+1, tickets, path+" "+tickets[i][1]);
                used[i] = false;
            }
        }
    }
}