import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solution();
        }

        System.out.println(sb.toString().trim());
    }

    static void solution() throws IOException {
        char[] commands = br.readLine().toCharArray();
        int l = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        String str = br.readLine();
        str = str.substring(1, str.length() - 1);
        String[] split = str.split(",");
        for (int j = 0; j < l; j++) {
            deque.offerLast(Integer.parseInt(split[j]));
        }

        boolean head = true;

        for (int j = 0; j < commands.length; j++) {
            char c = commands[j];
            if (c == 'R') {
                head = !head;
            }
            if (c == 'D') {
                if (deque.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                }

                if (head) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append("[");
        if (head) {
            while (!deque.isEmpty()) {
                answer.append(deque.pollFirst());
                answer.append(",");
            }
        } else {
            while (!deque.isEmpty()) {
                answer.append(deque.pollLast());
                answer.append(",");
            }
        }

        if (answer.length() > 1) answer.deleteCharAt(answer.length() - 1);
        answer.append("]");
        answer.append("\n");
        sb.append(answer);
    }
}