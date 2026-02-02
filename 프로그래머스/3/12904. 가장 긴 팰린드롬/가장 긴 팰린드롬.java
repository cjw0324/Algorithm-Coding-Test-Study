class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            if (charArr[i] == charArr[i + 1]) {
                dp[i][i + 1] = 1;
                answer = 2;
            }
        }
        for (int k = 3; k <= len; k++) {
            for (int i = 0; i<= len - k; i++) {
                int j = i + k - 1;
                if (charArr[i] == charArr[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    answer = Math.max(answer, k);
                }
            }
        }
        return answer;
    }
}