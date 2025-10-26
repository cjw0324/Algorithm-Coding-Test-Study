import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] parent;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);
        for (int i = 2; i<=n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (parent[next] != next) continue;
                parent[next] = now;
                queue.offer(next);
            }
        }
    }
}