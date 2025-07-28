import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<int[]> stack = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i<progresses.length; i++) {
            stack.offerLast(new int[]{progresses[i], speeds[i]});
        }
        
        while (!stack.isEmpty()) {
            for (int i = 0; i<stack.size(); i++) {
                int[] selectProgress = stack.pollFirst();
                int progress = selectProgress[0] + selectProgress[1];
                if (progress >=100) progress = 100;
                stack.offerLast(new int[]{progress,selectProgress[1]});
            }
            int deployCount = 0;
            int[] selectProgress = stack.peekFirst();
            while(!stack.isEmpty() && selectProgress[0] == 100) {
                deployCount++;
                stack.pollFirst();
                selectProgress = stack.peekFirst();
            }
            if (deployCount > 0) answer.add(deployCount);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}