import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.offer(s);
        }
        while (queue.peek() < K){
            int first = queue.poll();
            if (queue.isEmpty()) return -1;
            int second = queue.poll();
            int next = first + second * 2;
            count++;
            queue.offer(next);
        }
        return count;
    }
}