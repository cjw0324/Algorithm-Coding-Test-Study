import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        Arrays.fill(student, 1);
        
        for (int i : lost) {
            student[i - 1]--;
        }
        
        for (int i : reserve) {
            student[i - 1]++;
        }
        
        //System.out.println(Arrays.toString(student));
        
        for (int i = 0; i<n; i++) {
            if (student[i] == 0) {
                if (i>0 && student[i - 1] == 2) {
                    student[i - 1]--;
                    student[i]++;
                } else if (i<n-1 && student[i + 1] == 2) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }
        
        //System.out.println(Arrays.toString(student));
        
        int answer = 0;
        
        for (int i : student) {
            if (i >= 1) answer++;
        }
        
        return answer;
    }
}
