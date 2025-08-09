import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int lt = 0;
        int rt = people.length - 1;
        int boat = 0;
        Arrays.sort(people);
        while (lt <= rt) {
            if (people[lt] + people[rt] <= limit) {
                boat++;
                lt++;
                rt--;
            } else {
                boat++;
                rt--;
            }
        }
        return boat;
    }
}