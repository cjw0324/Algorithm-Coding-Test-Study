import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> use = new ArrayList<>();
        for(int i = 0; i<9; i++) {
            use.add(new HashSet<Integer>());
        }
        use.get(0).add(0);
        use.get(1).add(N);
        
        for(int i = 2; i<9; i++) {
            Set<Integer> nowSet = use.get(i);
            for (int j = 1; j< i; j++) {
                Set<Integer> preSet = use.get(j);
                Set<Integer> postSet = use.get(i - j);
                
                for (int pre : preSet) {
                    for(int post : postSet) {
                        nowSet.add(pre + post);
                        nowSet.add(pre - post);
                        nowSet.add(pre * post);
                        if (post != 0) {
                            nowSet.add(pre / post);
                        }
                    }
                }
            }
            
            nowSet.add(Integer.parseInt((Integer.toString(N)).repeat(i)));
        }
        
        for (Set<Integer> searchSet : use) {
            if (searchSet.contains(number)) return use.indexOf(searchSet);
        }
        
        return  -1;
    }
}