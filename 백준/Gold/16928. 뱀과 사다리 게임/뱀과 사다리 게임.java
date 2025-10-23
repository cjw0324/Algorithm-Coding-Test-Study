import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static HashMap<Integer, Integer> jump;
    static boolean[] visited;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        jump = new HashMap<>();
        visited = new boolean[101];
        dist = new int[101];

        Arrays.fill(dist, INF);


        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jump.put(start, end);
        }

        bfs();
        System.out.println(dist[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        dist[1] = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == 100) {
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) continue;
                if (visited[next]) continue;

                int before = next;
                while(true) {
                    if (jump.containsKey(next)) {
                        visited[next] = true;
                        dist[next] = dist[now] + 1;
                        next = jump.get(next);
                    } else {
                        break;
                    }
                }


                visited[next] = true;
                dist[next] = Math.min(dist[next], dist[now] + 1);

                queue.offer(next);
            }
        }
    }
}
