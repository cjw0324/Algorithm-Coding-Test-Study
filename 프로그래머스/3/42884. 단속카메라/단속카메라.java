import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int count = 0;
        int camera = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (camera < route[0]) {
                count++;
                camera = route[1];
            }
        }
        return count;
    }
}