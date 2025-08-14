import java.io.*;
import java.util.*;
public class Main {
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i  = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
            } else if (command == 2) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            } else if (command == 3) {
                if (deque.isEmpty()) write(-1);
                else write(deque.pollFirst());
            } else if (command == 4) {
                if (deque.isEmpty()) write(-1);
                else write(deque.pollLast());
            } else if (command == 5) {
                write(deque.size());
            } else if (command == 6) {
                if(deque.isEmpty()) write(1);
                else write(0);
            } else if (command == 7) {
                if(deque.isEmpty()) write(-1);
                else write(deque.peekFirst());
            } else if (command == 8) {
                if(deque.isEmpty()) write(-1);
                else write(deque.peekLast());
            }
        }

        System.out.println(answer);
    }

    static void write(int n) {
        answer.append(n).append("\n");
    }
}