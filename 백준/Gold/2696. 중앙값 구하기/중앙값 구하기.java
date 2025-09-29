import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>((n1, n2) -> n2 - n1);
            PriorityQueue<Integer> minPQ = new PriorityQueue<>((n1, n2) -> n1 - n2);
            sb.append((m + 1) / 2).append("\n");
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (j % 10 == 0) {
                     st = new StringTokenizer(br.readLine(), " ");
                }
                int n = Integer.parseInt(st.nextToken());

                if (maxPQ.isEmpty()) {
                    maxPQ.offer(n);
                } else {
                    if (n <= maxPQ.peek()) {
                        maxPQ.offer(n);
                    } else {
                        minPQ.offer(n);
                    }
                }

                if (maxPQ.size() < minPQ.size()) {
                    maxPQ.offer(minPQ.poll());
                } else if (maxPQ.size() > minPQ.size() + 1) {
                    minPQ.offer(maxPQ.poll());
                }

                if (j % 2 == 0) {
                    if (count == 9 || j == m - 1) {
                        sb.append(maxPQ.peek()).append("\n");
                        count = 0;
                    } else {
                        sb.append(maxPQ.peek() + " ");
                    }
                    count++;
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}