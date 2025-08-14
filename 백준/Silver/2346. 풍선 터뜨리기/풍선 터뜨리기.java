import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] moves = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }


        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i<n; i++) {
            deque.offerLast(i);
        }

        int move = moves[deque.pollFirst()];
        sb.append(1).append(" ");
        while(!deque.isEmpty()) {
            if (move > 0) { //오른쪽 이동
                for (int i = 1; i<move; i++) {
                    deque.offerLast(deque.pollFirst());
                }

            } else { //왼쪽 이동
                for (int i = 0; i > move; i--) {
                    deque.offerFirst(deque.pollLast());
                }
            }
            int next = deque.pollFirst();
            move = moves[next];
            sb.append(next+1).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}