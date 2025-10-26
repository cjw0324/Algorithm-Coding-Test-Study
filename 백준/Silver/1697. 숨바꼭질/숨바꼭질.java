
import java.io.*;
import java.util.*;
public class Main {
    static int[] dist = new int[100_001];
    static int n, k;
    static int[] move = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(dist, Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        dist[n] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) return dist[k];

            for (int i = 0; i<3; i++) {
                int nx = now;
                if (i == 2) {
                    nx *= 2;
                } else {
                    nx += move[i];
                }

                if (nx < 0 || nx > 100_000 || dist[nx] != Integer.MAX_VALUE) {
                    continue;
                }

                dist[nx] = dist[now] + 1;
                queue.offer(nx);
            }
        }

        return dist[k];
    }



}
