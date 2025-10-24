import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = {{'A', 'C', 'A', 'G'}, {'C', 'G', 'T', 'A'}, {'A', 'T', 'C', 'G'}, {'G', 'A', 'G', 'T'}};;
    static int n;
    static char[] DNA = {'A', 'G', 'C', 'T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        while (stack.size() > 1) {
            int row = getIndex(stack.pop());
            int col = getIndex(stack.pop());
            stack.push(map[row][col]);
        }

        System.out.println(stack.pop());

    }

    static int getIndex(char c) {
        for (int i = 0; i < 4; i++) {
            if (DNA[i] == c) {
                return i;
            }
        }
        return -1;
    }
}