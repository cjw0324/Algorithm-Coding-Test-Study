import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String converted = Long.toString(n, k);
        
        String[] split = converted.split("0");
        
        
        for (String s : split) {
            try {
                if(isPrime(Long.parseLong(s))) answer++;    
            } catch (NumberFormatException e) {
                continue;
            }
            
        }
        
        
        return answer;
    }
    
    static boolean isPrime(long x) {
        if (x < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x%i==0) return false;
        }
        
        return true;
    }
}