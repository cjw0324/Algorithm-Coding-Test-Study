
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);

            } else if (command.equals("pop")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command.equals("front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}