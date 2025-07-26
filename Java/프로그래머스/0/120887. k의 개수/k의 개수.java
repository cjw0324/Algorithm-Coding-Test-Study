class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int d = i; d<= j; d++) {
            char[] numCharArray = Integer.toString(d).toCharArray();
            for (char c : numCharArray) {
                if ((c+"").equals(Integer.toString(k))) answer++;
            }
        }
        return answer;
    }
}