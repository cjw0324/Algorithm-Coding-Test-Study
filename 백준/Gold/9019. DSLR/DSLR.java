import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static boolean[] visited;
    static int[] parent;
    static char[] how;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append('\n');
        }
        System.out.print(sb);
    }

    static String bfs(int start, int target) {
        visited = new boolean[10000];
        parent = new int[10000];
        how = new char[10000];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        parent[start] = -1;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if (now == target) break;

            int D = (now * 2) > 9999 ? (now * 2) % 10000 : now * 2;
            int S = now == 0 ? 9999 : now - 1;
            int L = ((now % 1000) * 10) + (now / 1000);
            int R = ((now % 10) * 1000) + (now / 10);

            if (!visited[D]) {
                visited[D] = true;
                parent[D] = now;
                how[D] = 'D';
                queue.offer(D);
            }
            if (!visited[S]) {
                visited[S] = true;
                parent[S] = now;
                how[S] = 'S';
                queue.offer(S);
            }
            if (!visited[L]) {
                visited[L] = true;
                parent[L] = now;
                how[L] = 'L';
                queue.offer(L);
            }
            if (!visited[R]) {
                visited[R] = true;
                parent[R] = now;
                how[R] = 'R';
                queue.offer(R);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cur = target;
        while (parent[cur] != -1) {
            sb.append(how[cur]);
            cur = parent[cur];
        }
        return sb.reverse().toString().trim();
    }
}
