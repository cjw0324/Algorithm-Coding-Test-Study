class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        for (char c : arr) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int n = name.length();
        int move = n - 1;
        for (int i = 0; i<n; i++) {
            int next = i+1;
            while (next < n && arr[next] == 'A') {
                next++;
            }
            int tail = n - next;
            
            int right = 2 * i + tail;
            int left = 2 * tail + i;
            
            move = Math.min(move, Math.min(left, right));
        }
        
        return answer + move;
    }
}