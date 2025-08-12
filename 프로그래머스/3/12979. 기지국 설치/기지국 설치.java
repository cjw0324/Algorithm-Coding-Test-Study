class Solution {
    public int solution(int n, int[] stations, int w) {
        int start = 1;
        int count = 0;
        for (int station : stations) {
            int first = station - w;
            int end = station + w;
            int distance = first - start;
            if (distance > 0) {
                count += distance % (2 * w + 1) == 0 ? distance / (2 * w + 1) : (distance / (2 * w + 1)) + 1;            
            }
            start = end + 1;
        }
        if (start <= n) {
            int remain = n - start + 1;
            count += remain % (2 * w + 1) == 0 ? remain / (2 * w + 1) : (remain / (2 * w  + 1)) + 1;
        }
        return count;
    }
}