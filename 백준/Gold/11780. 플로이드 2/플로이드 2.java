import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;
    static List<Integer>[][] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        route = new List[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                route[i][j] = new ArrayList<>();
            }
        }

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dist[a][b] > c) {
                dist[a][b] = c;
                route[a][b] = new ArrayList<>();
                route[a][b].add(a);
                route[a][b].add(b);
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            List<Integer> head = route[i][k];
                            List<Integer> tail = route[k][j];
                            route[i][j] = new ArrayList<>();
                            route[i][j].add(i);
                            for (int x : head) {
                                if (x == i || x == k) {
                                    continue;
                                }
                                route[i][j].add(x);
                            }
                            route[i][j].add(k);
                            for (int x : tail) {
                                if (x == j || x == k) {
                                    continue;
                                }
                                route[i][j].add(x);

                            }
                            route[i][j].add(j);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append(0 + " ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                List<Integer> list = route[i][j];
                if (list.size() == 0) {
                    sb.append(0);
                } else {
                    sb.append(list.size() + " ");
                    for (int n : list) {
                        sb.append(n + " ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}