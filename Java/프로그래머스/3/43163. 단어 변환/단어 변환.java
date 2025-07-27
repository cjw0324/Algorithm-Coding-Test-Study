import java.util.*;
class Solution {
    static String target_str;
    static int count = Integer.MAX_VALUE;
    static boolean[] checked;

    public int solution(String begin, String target, String[] words) {
        checked = new boolean[words.length];
        target_str = target;

        DFS(0, begin, words);
        
        if(count == Integer.MAX_VALUE){
            return 0;
        }
        return count;
    }

    public void DFS(int depth, String str, String[]words){
        if (str.equals(target_str)) {
            count = Math.min(depth, count);
        } 
        else {
            for (int i = 0; i < words.length; i++) {
                if (diff(str, words[i]) && !checked[i]) { //1개 알파벳만 다를때
                    checked[i] = true;
                    DFS(depth + 1, words[i], words);
                    checked[i] = false;
                }
            }
        }
    }


    public boolean diff(String a, String b) {
        char[] aarr = a.toCharArray();
        char[] barr = b.toCharArray();
        int count = 0;
        for (int i =0; i< aarr.length; i++) {
            if (aarr[i] != barr[i]) {
                count++;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
