import java.util.*;
class Solution {
    static int total = 0;
    static Set<Set<String>> result = new HashSet<>();
    static int u, b;
    static String[] user_id;
    static String[] banned_id;
    public int solution(String[] user_id, String[] banned_id) {
        u = user_id.length;
        b = banned_id.length;
        this.user_id = user_id.clone();
        this.banned_id = banned_id.clone();
    
        dfs(new HashSet<>(),0);
        
        System.out.println(result);
        
        return result.size();
    }
    
    
    static void dfs(HashSet<String> set,int depth) {
        if (depth == b) {
            if (set.size() == b) {
                result.add(set);    
            }
            return;
        }
        
        for (int j = 0; j < u; j++) {
            String banned = banned_id[depth];
            String user = user_id[j];
            if (!set.contains(user) && samecheck(banned, user)) {
                set.add(user);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(user);
            }
        }
    }
    
    
    static boolean samecheck(String banned, String user) {
        if (user.length() != banned.length()) return false;
        char[] b = banned.toCharArray();
        char[] u = user.toCharArray();
        for (int i = 0; i<b.length; i++) {
            if (b[i] == '*') continue;
            if (b[i] != u[i]) return false;
        }
        
        return true;
    }
}