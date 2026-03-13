class Solution
{
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int answer = 1;
        for (int i = 0; i<len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i<len - 1; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
                answer = 2;
            }
        }
        for (int length = 3; length <= len; length++) {
            for (int start = 0; start<=len - length; start++) {
                int end = start + length - 1;
                if (arr[start] == arr[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    answer = length;
                }
            }
        }
        return answer;
    }
}