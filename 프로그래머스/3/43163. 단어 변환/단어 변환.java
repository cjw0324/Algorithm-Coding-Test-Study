import java.util.*;
class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        BFS(begin, target, words);
        return answer;
    }
    
    
    public void BFS(String begin, String target, String[] words) {
        int change = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        while(!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {   
                String now = queue.poll();

                if (now.equals(target)) {
                    answer = change;
                    return;
                }

                for (int j = 0; j<words.length; j++) {
                    if (!visited[j] && checkingDiffOnlyOne(now, words[j])) {
                        queue.offer(words[j]);
                        visited[j] = true;
                    }
                }
            }
            change++;
        }
        
        
    }
    
    
    public boolean checkingDiffOnlyOne (String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int diff = 0;
        
        for (int i = 0; i<c1.length; i++) {
            if (c1[i] != c2[i]) diff++;
        }
        
        if (diff == 1) return true;
        return false;
    }
}