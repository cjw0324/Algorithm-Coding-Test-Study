import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<Integer>[] graph;
    static StringBuffer dfsResult = new StringBuffer();
    static StringBuffer bfsResult = new StringBuffer();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int n = 1; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (!graph[node1].contains(node2)) {
                graph[node1].add(node2);
            }
            if (!graph[node2].contains(node1)) {
                graph[node2].add(node1);
            }
        }
        for (int n = 1; n <= N; n++) {
            Collections.sort(graph[n]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        Arrays.fill(visited, false);
        bfs();

        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }

    public static void dfs(int now) {
        visited[now] = true;
        dfsResult.append(now).append(" ");
        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            bfsResult.append(now).append(" ");
            for (int next : graph[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}