import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int start, end;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine(), " ");

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        Dijkstra(start);
    }

    static void Dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().index;

            if (!visited[now]) {
                visited[now] = true;

                for (Node next : graph[now]) {
                    if (dist[next.index] > dist[now] + next.cost) {
                        dist[next.index] = dist[now] + next.cost;

                        pq.offer(new Node(next.index, dist[next.index]));
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}