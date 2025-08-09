import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long max = (long) Arrays.stream(times).max().getAsInt() * (long) n;
        long min = 1;
        long answer = 0;
        
        while(min < max){
            long mid = (min + max) / 2;
            long sum = 0;
            for(int time : times) {
                sum += mid / (long) time;
            }
            if (sum >= n) {
                answer = mid;
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
}