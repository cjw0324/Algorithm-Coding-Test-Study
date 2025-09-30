import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int index = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem " + index + ": " + Dijkstra(graph, n) + "\n");
            index++;
        }
        System.out.println(sb.toString().trim());
    }

    static int Dijkstra(int[][] graph, int n) {
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = graph[0][0];


        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(0, 0, dist[0][0]));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.x][now.y]) {
                visited[now.x][now.y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (dist[nx][ny] > dist[now.x][now.y] + graph[nx][ny]) {
                            dist[nx][ny] = dist[now.x][now.y] + graph[nx][ny];
                            pq.offer(new Node(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }

    static void print(int[][] map) {
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
    }


    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}