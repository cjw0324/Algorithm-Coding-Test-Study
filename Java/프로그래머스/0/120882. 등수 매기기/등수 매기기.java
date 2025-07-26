import java.util.*;
class Solution {
    
    static int length;
    
    public int[] solution(int[][] score) {
        
        length = score.length;
        
        Double[] avg = new Double[length];
        
        for (int i = 0; i<length; i++){
            avg[i] = (double)(score[i][0] + score[i][1]) / 2; 
        }
        
        Double[] sortAvg = avg.clone();
        
        Arrays.sort(sortAvg, Collections.reverseOrder());
        
        for (double d : avg) {
            System.out.print(d + ", ");  
        }
        
        System.out.println();
        
        for (double d : sortAvg) {
            System.out.print(d + ", ");  
        }
        
        int[] studentScore = new int[length];
        for (int i = 0; i< length; i++) {
            if (i == 0) studentScore[0] = 1;
            else {
                if (sortAvg[i - 1].equals(sortAvg[i])) {
                    studentScore[i] = studentScore[i - 1];
                } else {
                    studentScore[i] = i + 1;
                }
            }
        }
        
        System.out.println();
        
        for (int d : studentScore) {
            System.out.print(d + ", ");  
        }
        
        int[] result = new int[length];
        
        for (int i = 0; i<length; i++) {
            for (int j = 0; j<length; j++) {
                if (avg[i] == sortAvg[j]) {
                    result[i] = studentScore[j];
                }
            }
        }
        
        System.out.println();
        
        for (int d : result) {
            System.out.print(d + ", ");  
        }
        
        return result;
    }
}