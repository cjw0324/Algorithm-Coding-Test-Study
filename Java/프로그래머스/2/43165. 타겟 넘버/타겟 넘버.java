import java.util.*;
class Solution {
    static int[] numbers;
    static int target;
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers.clone();
        this.target = target;
        
        DFS(0, 0);
        return answer;
    }
    
    public void DFS (int d, int sum) {
        if (d == numbers.length) {
            if (sum == target) answer++;
        }
        else {
            DFS(d+1, sum+numbers[d]);
            DFS(d+1, sum-numbers[d]);
        }
    }
}