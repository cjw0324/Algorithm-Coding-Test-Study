import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        String[] binary = new String[n];

        // 1) 2진수 & (2^k - 1) 길이로 왼쪽 0 패딩 후 배열에 저장
        for (int i = 0; i < n; i++) {
            String bin = Long.toString(numbers[i], 2);
            binary[i] = padToFullTree(bin); // 반드시 배열에 다시 넣기!
        }

        // 2) 각 케이스 확인
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = checkBinaryTree(binary[i], false) ? 1 : 0;
        }
        return answer;
    }

    // (2^k - 1) 길이가 될 때까지 왼쪽에 '0' 패딩
    private String padToFullTree(String s) {
        int len = s.length();
        int size = 1;                 // 1, 3, 7, 15, ...
        while (size < len) size = size * 2 + 1;
        int pad = size - len;
        if (pad == 0) return s;

        // Java 11 이상이면 다음 한 줄로 가능: return "0".repeat(pad) + s;
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < pad; i++) sb.append('0');
        sb.append(s);
        return sb.toString();
    }

    // 부모가 0이면(= parentZero) 자식은 모두 0이어야 함
    public boolean checkBinaryTree(String str, boolean parentZero) {
        int len = str.length();
        if (len == 0) return true; // 방어적
        if (len == 1) {
            char root = str.charAt(0);
            // 부모가 0인데 내가 1이면 불가
            if (parentZero) { //부모가 0일때
                if (root == '1') return false;
                else return true;
            } else{ //부모가 1일때
                return true;
            }
        }

        int mid = len / 2;
        char root = str.charAt(mid);

        if (parentZero && root == '1') return false;

        String left  = str.substring(0, mid);
        String right = str.substring(mid + 1, len);

        boolean nextParentZero = parentZero || (root == '0');
        return checkBinaryTree(left, nextParentZero) && checkBinaryTree(right, nextParentZero);
    }
}
