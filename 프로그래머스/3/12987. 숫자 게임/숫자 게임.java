import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> queueA = new PriorityQueue<>();
        PriorityQueue<Integer> queueB = new PriorityQueue<>();
        
        for (int i = 0; i<A.length; i++) {
            queueA.offer(A[i]);
            queueB.offer(B[i]);
        }
        
        int win = 0;
        
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (queueA.peek() >= queueB.peek()) {
                queueB.poll();
            } else {
                win++;
                queueA.poll();
                queueB.poll();
            }
        }
        
        return win;
    }
}