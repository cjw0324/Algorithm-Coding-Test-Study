

import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().toCharArray();
        while(true) {
            if (temp.length==1 && temp[0]== '.') {
                return;
            }


            check(temp);

            temp = br.readLine().toCharArray();

        }

    }

    static void check(char[] arr) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : arr) {
            if (c == '(') {
                stack.offerFirst(c);
            } else if (c == ')') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.pollFirst() != '(')) {
                    System.out.println("no");
                    return;
                }
            } else if (c == '[') {
                stack.offerFirst(c);
            } else if (c == ']') {
                if (stack.isEmpty() || (!stack.isEmpty() && stack.pollFirst() != '[')) {
                    System.out.println("no");
                    return;
                }
            } else continue;
        }
        if (!stack.isEmpty()) {
            System.out.println("no");
            return;
        }
        System.out.println("yes");
    }

}