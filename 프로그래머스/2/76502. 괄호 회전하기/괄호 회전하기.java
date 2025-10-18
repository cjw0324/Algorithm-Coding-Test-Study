import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i<s.length(); i++) {
            if (i == 0) {
                if (isCorrect(s)) answer++; 
            } else {
                s = round(s);
                if (isCorrect(s)) answer++; 
            }
        }
        
        return answer;
    }
    
    
    static String round(String s) {
        String tmp = "";
        tmp += s.substring(1,s.length());
        tmp += s.substring(0,1);
        return tmp;
    }
    
    static boolean isCorrect(String str) {
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = ' ';
                if (c == '}') {
                    top = stack.peek();
                    if (top != '{') return false;
                    stack.pop();
                } else if (c == ']') {
                    top = stack.peek();
                    if (top != '[') return false;
                    stack.pop();
                } else {
                    top = stack.peek();
                    if (top != '(') return false;
                    stack.pop();
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
