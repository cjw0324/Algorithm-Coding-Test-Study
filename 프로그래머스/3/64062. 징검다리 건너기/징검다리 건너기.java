import java.util.*;
class Solution {
    static int k;
    
    public int solution(int[] stones, int k) {
        int max = Arrays.stream(stones).max().getAsInt();
        int min = 0;
        this.k = k;
        int answer = 0;
        while(max >= min) {
            int mid = (max + min) / 2;
            if (crossAvailable(mid, stones)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return answer + 1;
    }
    
    
    public boolean crossAvailable(int friends, int[] stones) {
        int remove = 0;
        for (int stone : stones){
            if (stone - friends <= 0) remove++;
            else remove = 0;
            if (remove >= k) return false;
        }
        return true;
    }
}