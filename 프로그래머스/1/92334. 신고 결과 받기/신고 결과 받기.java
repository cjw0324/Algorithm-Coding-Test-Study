import java.util.*;
class Solution {
    static HashMap<String, Integer> count;
    static HashMap<String, Set<String>> reportMap;
    public int[] solution(String[] id_list, String[] report, int k) {
        count = new HashMap<>();
        reportMap = new HashMap<>();

        for(String id : id_list) {
            count.put(id, 0);
            reportMap.put(id, new HashSet<String>());
        }
        
        
        for (String r : report) {
            String[] info = r.split(" ");
            reportMap.get(info[1]).add(info[0]);
        }
        
        for (String id : id_list) {
            if (reportMap.get(id).size() >= k) {
                for (String user : reportMap.get(id)) {
                    int user_count = count.get(user) + 1;
                    count.put(user, user_count);
                }
            }
        }
        
        // for (String id : count.keySet()) {
        //     System.out.println(id +" : "+count.get(id));
        // }
        
        int[] answer = new int[id_list.length];
        int index = 0;
        for (String id : id_list) {
            answer[index] = count.get(id);
            index++;
        }
        
        return answer;
        
    }
}