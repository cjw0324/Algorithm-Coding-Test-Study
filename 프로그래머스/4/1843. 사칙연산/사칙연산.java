class Solution {
    static int[] nums;
    static String[] operators;
    static int[][] dpMax;
    static int[][] dpMin;
    public int solution(String arr[]) {
        int length = arr.length; //7
        int numlength = length / 2 + 1; //4 
        int oplength = length / 2; //3
        nums = new int[numlength];
        operators = new String[oplength];
        dpMax = new int[numlength][numlength];
        dpMin = new int[numlength][numlength];
        
        for (int i = 0; i< numlength; i++) {
            nums[i] = Integer.parseInt(arr[i * 2]);    
        }
        
        for (int i = 0; i< oplength; i++) {
            operators[i] = arr[i * 2 + 1];
        }
        
        for (int i = 0; i<numlength; i++) {
            for (int j = 0; j<numlength; j++) { 
                if (i == j) {
                    dpMax[i][j] = nums[i];
                    dpMin[i][j] = nums[i];
                } else {
                    dpMax[i][j] = Integer.MIN_VALUE;
                    dpMin[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int len = 1; len < numlength; len++) {
            for (int i = 0; i< numlength - len; i++) {
                int j = i + len;
                
                for (int k = i; k < j; k++) {
                    String operator = operators[k];
                    int maxLeft = dpMax[i][k];
                    int maxRight = dpMax[k+1][j];
                    int minLeft = dpMin[i][k];
                    int minRight = dpMin[k+1][j];
                    
                    if (operator.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], maxLeft + maxRight);
                        dpMin[i][j] = Math.min(dpMin[i][j], minLeft + minRight);
                    }
                    else {
                        dpMax[i][j] = Math.max(dpMax[i][j], maxLeft - minRight);
                        dpMin[i][j] = Math.min(dpMax[i][j], minLeft - maxRight);
                    }
                }
            }
        }
        
        return dpMax[0][numlength - 1];
        
    }
}