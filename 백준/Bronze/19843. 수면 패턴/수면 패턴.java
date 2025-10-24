//package template_baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static Map<String, Integer> map = new HashMap<>();
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map.put("Mon", 0);
        map.put("Tue", 1);
        map.put("Wed", 2);
        map.put("Thu", 3);
        map.put("Fri", 4);

        for (int i = 0; i < n; i++) {
            int sleep = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int start = map.get(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            int end = map.get(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            if (start == end) {
                sleep = (out - in);
            } else {
                sleep = (24 - in) + out + (end - start - 1) * 24;
            }
            total += sleep;
        }


        if (total >= t) {
            System.out.println(0);
        } else if (t - total > 48) {
            System.out.println(-1);
        } else {
            System.out.println(t - total);
        }
    }
}
