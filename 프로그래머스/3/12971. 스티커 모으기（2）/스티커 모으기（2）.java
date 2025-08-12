class Solution {
    static int n;
    public int solution(int sticker[]) {
        n = sticker.length;
        int[] first = new int[n];
        int[] last = new int[n];
        for (int i = 0; i<n; i++){
            if(i == 0) {
                first[i] = 0;
                last[i] = 0;
            } else {
                first[i] = sticker[i-1];
                last[i] = sticker[i];
            }
        }
        
        if(n == 1) {
            return sticker[0];
        }
        
        int[] dpFirst = new int[n];
        int[] dpLast = new int[n];
        
        for (int i = 0; i<n; i++) {
            if (i < 2) {
                dpFirst[i] = first[i];
                dpLast[i] = last[i];
            } else {
                dpFirst[i] = Math.max(dpFirst[i-2] + first[i], dpFirst[i-1]);
                dpLast[i] = Math.max(dpLast[i-2] + last[i], dpLast[i-1]);
            }
        }
        
        return Math.max(dpFirst[n-1], dpLast[n-1]);
    }
}