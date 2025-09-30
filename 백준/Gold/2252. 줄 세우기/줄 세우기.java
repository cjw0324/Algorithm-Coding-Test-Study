import java.io.*;
import java.util.*;

public class Main {
    static int[] degree;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        visited = new boolean[n + 1];
        degree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            degree[end]++;
            graph[start].add(end);
        }

        topologySort();
    }

    static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0){
                queue.offer(i);
                visited[i] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty()) {
                return;
            }

            int now = queue.poll();
            sb.append(now + " ");
            for (int next : graph[now]) {
                degree[next]--;
                if (degree[next] == 0 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}