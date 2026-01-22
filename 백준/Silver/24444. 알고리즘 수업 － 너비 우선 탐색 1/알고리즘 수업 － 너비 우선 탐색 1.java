import java.io.*;
import java.util.*;

/**
 * N 개 정점, M 개 간선 무방향 그래프
 * 모든 간선 가중치 1
 * 정점 R 시작하여 BFS 탐색 시 방문 순서 출력
 * 방문 순서는 정점 번호의 오름차순
 */

public class Main {
    static StringTokenizer st;
    static int N, M, R;
    static PriorityQueue<Integer>[] graph;
    static boolean[] visited;
    static int score = 1;
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue[N + 1];
        for (int n = 0; n <= N; n++) {
            graph[n] = new PriorityQueue<>((n1, n2) -> n1 - n2);
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        order = new int[N + 1];
        visited = new boolean[N + 1];

        bfs();

        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);
        visited[R] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            order[now] = score++;
            while(!graph[now].isEmpty()) {
                int next = graph[now].poll();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

    }
}