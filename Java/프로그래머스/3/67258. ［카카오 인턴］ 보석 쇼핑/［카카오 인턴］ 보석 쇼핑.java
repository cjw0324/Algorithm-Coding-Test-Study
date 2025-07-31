import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String s : gems) {
            set.add(s);
        }
        
        count = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        
        
        int lt = 0;
        int rt = 0;

        int[] result = new int[]{1,gems.length};
        
        map.put(gems[0], 1);
        
        while (lt <= rt) {
            if (map.size() == count) {
                if ((rt - lt) < (result[1] - result[0]) || ((rt - lt) == (result[1] - result[0]) && lt < result[0] - 1)) {
                    result[0] = lt + 1;
                    result[1] = rt + 1;
                }
            }
            
            if (map.size() < count) {
                rt++;
                if (rt == gems.length) break;
                
                map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1); //있으면 get.(germs[rt]) 값 사용, 없으면 0 사용 
            }
            else {
                map.put(gems[lt], map.get(gems[lt]) - 1);
                if (map.get(gems[lt]) == 0) {
                    map.remove(gems[lt]);
                }
                lt++;
            }
        }
        
        return result;
    }
}