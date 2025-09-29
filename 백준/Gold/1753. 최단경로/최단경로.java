import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static int k;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        graph = new List[v + 1];
        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }


        Dijkstra(k);
    }

    static void Dijkstra(int start) {
        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]  = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
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
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=v; i++) {
            int d = dist[i];
            if (d == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(d).append("\n");
            }
        }

        System.out.println(sb.toString().trim());

    }

    static class Node {
        int index;
        int cost;

        public Node(int i, int c) {
            this.index = i;
            this.cost = c;
        }
    }
}