import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long right = Arrays.stream(times).max().getAsInt() * (long) n;
        long left = 1;
        long answer = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long capacity = 0;
            for (int t : times) {
                capacity += mid / (long) t;
            }
            
            if(capacity < n) { // 처리 할 수 없다.
                left = mid + 1;
            } else { // 처리 할 수 있다.
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}