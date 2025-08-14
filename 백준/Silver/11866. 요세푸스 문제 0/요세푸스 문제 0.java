import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i<=n; i++) {
            deque.offerLast(i);
        }

        int count = 1;
        sb.append("<");
        boolean first = true;
        while (!deque.isEmpty()) {
            if (count == k) {
                if(first) {
                    sb.append(deque.pollFirst());
                    first = false;
                } else {
                    sb.append(", ").append(deque.pollFirst());
                }
                count = 1;
            } else {
                deque.offerLast(deque.pollFirst());
                count++;
            }
        }


        sb.append(">");

        System.out.println(sb);
    }

}