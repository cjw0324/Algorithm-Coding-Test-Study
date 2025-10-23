import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] color; // 0: 미방문, 1: 빨강, -1: 파랑
    static int V, E;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            color = new int[V + 1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

            // 간선 입력
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1; // 시작은 빨강

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (color[next] == 0) {
                    color[next] = -color[now]; // 인접 노드는 반대 색
                    q.offer(next);
                } else if (color[next] == color[now]) {
                    return false; // 같은 색끼리 연결되면 이분 아님
                }
            }
        }
        return true;
    }
}
