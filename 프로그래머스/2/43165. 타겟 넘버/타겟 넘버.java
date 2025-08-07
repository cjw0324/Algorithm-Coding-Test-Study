class Solution {
    static int length;
    static int answer = 0;
    static int[] numbers;
    static int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers.clone();
        length = numbers.length;
        this.target = target;
        DFS(0,0);
        return answer;
    }
    
    
    
    public void DFS(int depth, int sum) {
        if (depth == length) {
            if (sum == target) {
                answer++;            
            } else {
                return;
            }
        } else {
            DFS(depth + 1, sum + numbers[depth]);
            DFS(depth + 1, sum - numbers[depth]);
        }
    }
}