import java.io.*;
import java.util.*;

/**
 * N 개 정점, M 개 간선 무방향 그래프
 * 모든 간선 가중치 1
 * 정점 R 시작하여 DFS 탐색 시 방문 순서 출력
 */

public class Main {
    static StringTokenizer st;
    static int N, M, R;
    static List<Integer>[] graph;
    static int[] order;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        for (int n = 0; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }
        order = new int[N + 1];
        order[R] = 1;
        count++;
        visited = new boolean[N + 1];

        for (int m = 0; m<M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int n = 0; n <= N; n++) {
            Collections.sort(graph[n]);
        }


        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void dfs(int now) {
        visited[now] = true;
        for (int next : graph[now]) {
            if (!visited[next]) {
                order[next] = ++count;
                dfs(next);
            }
        }
    }
}