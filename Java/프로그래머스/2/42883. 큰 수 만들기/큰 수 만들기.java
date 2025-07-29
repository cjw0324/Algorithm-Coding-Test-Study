import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new LinkedList<>();
        int remove = 0;
        
        for (char c : number.toCharArray()) {
            while (remove < k && !deque.isEmpty() && deque.peekLast() < c) {
                deque.pollLast();
                remove++;
            }           
            deque.offerLast(c);
        }
        
        while (remove < k) {
            deque.pollLast();
            remove++;
        }
        
        String answer = "";
        
        while (!deque.isEmpty()) {
            answer += deque.pollFirst();
        }
        
        return answer;
    }
}