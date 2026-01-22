import java.io.*;
import java.util.*;

/**
 * V 개 마을, E 개 도로
 * 마을 사이에는 도로, 단방향
 * 마을은 1번 ~ V번
 * 사이클을 찾는데, 가장 짧은 사이클이 필요하다!
 *
 */

public class Main {
    static StringTokenizer st;
    static int V, E;
    static int[][] dist;
    static final int INF = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine(), " ");
            /**
             * a -> b 로 가는 도로의 거리는 c
             */
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int start = 1; start <= V; start++) {
                for (int end = 1; end <= V; end++) {
                    if (start != end && dist[start][end] > dist[start][k] + dist[k][end]) {
                        dist[start][end] = dist[start][k] + dist[k][end];
                    }
                }
            }
        }

        int answer = INF;
        for (int start = 1; start <= V; start++) {
            for (int end = 1; end <= V; end++) {
                if (start != end && dist[start][end] != INF && dist[end][start] != INF) {
                    answer = Math.min(answer, dist[start][end] + dist[end][start]);
                }
            }
        }

        if (answer == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }
}
