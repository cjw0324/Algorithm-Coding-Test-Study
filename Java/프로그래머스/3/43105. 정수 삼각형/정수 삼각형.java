import java.util.*;
class Solution {
    static int[][] dpTable;
    public int solution(int[][] triangle) {
        dpTable = new int[triangle.length][triangle.length];
        dpTable[0][0] = triangle[0][0];
        
        for (int i = 1; i<triangle.length; i++) {
            for (int j = 0; j<= i; j++) {
                if (j == 0) {   //[i][j]
                    dpTable[i][j] = dpTable[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    dpTable[i][j] = dpTable[i-1][j-1] + triangle[i][j];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        /**
        for (int[] line : dpTable) {
            for (int d : line) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
        */
        Arrays.sort(dpTable[triangle.length - 1]);
        return dpTable[triangle.length - 1][triangle.length - 1];
    }
}