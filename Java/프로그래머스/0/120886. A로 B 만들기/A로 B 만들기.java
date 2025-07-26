class Solution {
    public int solution(String before, String after) {
        int[] check = new int[26];
        for (char c : before.toCharArray()){
            check[c - 'a']++;
        }
        
        for (char c : after.toCharArray()){
            check[c - 'a']--;
        }
        
        for (int i : check) {
            if (i != 0) return 0;
        }
        return 1;
    }
}