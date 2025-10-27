import java.util.*;
class Solution {
    static Map<String, List<String>> map;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        for (String[] cloth : clothes) {
            String key = cloth[1];
            String value = cloth[0];
            
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<String> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }
        if (map.size() == 0) return 0;
        int answer = 1;
        for (String key : map.keySet()) {
            int size = map.get(key).size() + 1;
            answer *= size;
        }
        
        return answer - 1;
    }
}