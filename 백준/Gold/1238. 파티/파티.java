import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x;
    static StringTokenizer st;
    static List<Node>[] graph;
    static int[] totalDistance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        totalDistance = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i <= n; i++) {
            Dijkstra(i, x, "go");
            Dijkstra(x, i, "back");
        }

//        System.out.println(Arrays.toString(totalDistance));
        System.out.println(Arrays.stream(totalDistance).max().getAsInt());
    }

    static void Dijkstra(int start, int end, String command) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
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

        if (command.equals("go")) totalDistance[start] += dist[end];
        else totalDistance[end] += dist[end];
    }

    public static class Node {
        int index;
        int cost;

        public Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}