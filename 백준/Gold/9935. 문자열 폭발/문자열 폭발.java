import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        char[] target = boom.toCharArray();
        Stack<Character> deque = new Stack<>();

        for (char c : str.toCharArray()) {
            deque.add(c);

            if (deque.size() >= boom.length()) {
                boolean same = true;
                for (int i = 0; i<boom.length(); i++) {
                    if (deque.get(deque.size() - target.length + i) != target[i]) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    for (int i = 0; i < boom.length(); i++) {
                        deque.pop();
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        if (deque.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        while (!deque.isEmpty()) {
            answer.append(deque.pop());
        }
        System.out.println(answer.reverse().toString().trim());
    }
}
