import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1) == Math.abs(n2)) return n1 - n2;
            else return Math.abs(n1) - Math.abs(n2);
        });

        StringBuilder sb = new StringBuilder();

        int testcase = 0;
        while (testcase < n) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(input);
            }
            testcase++;
        }

        System.out.println(sb.toString().trim());
    }

}