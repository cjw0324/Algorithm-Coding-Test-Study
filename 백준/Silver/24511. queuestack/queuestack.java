import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] type = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) type[i] = Integer.parseInt(st1.nextToken());

        int[] init = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) init[i] = Integer.parseInt(st2.nextToken());

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        // 큐(0)인 것만, 역순으로 뒤에 쌓기
        for (int i = n - 1; i >= 0; i--) {
            if (type[i] == 0) dq.offerFirst(init[i]);
        }

        // 매 입력 x: 앞에 넣고, 뒤에서 빼서 출력
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st3.nextToken());
            dq.offerFirst(x);
            sb.append(dq.pollLast()).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}