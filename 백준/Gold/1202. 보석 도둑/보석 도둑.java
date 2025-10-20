import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[n];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(w, v);
        }

        Arrays.sort(jewelries, (j1, j2) -> {
            if (j1.w == j2.w) {
                return j2.v - j1.v;
            }
            return j1.w - j2.w;
        });

        int[] bags = new int[k];

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);

        long totalPrice = 0;

        int index = 0;
        for (int i = 0; i<k; i++) {
            int bag = bags[i];
            while (index < n && jewelries[index].w <= bag) {
                pq.offer(jewelries[index].v);
                index++;
            }

            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }

    static class Jewelry {
        int w;
        int v;

        public Jewelry(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

}