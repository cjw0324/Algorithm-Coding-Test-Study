import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        if (pq.peek() >= K) return count;
        
        while (pq.size() >= 2) {
            int mix = pq.poll() + pq.poll() * 2;
            count++;
            pq.offer(mix);
            if (pq.peek() >= K) return count;
        }
        return -1;
    }
}