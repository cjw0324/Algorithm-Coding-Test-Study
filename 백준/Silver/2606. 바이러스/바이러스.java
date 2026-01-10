import java.io.*;
import java.util.*;

public class Main {
    static int Vertex, Edge;
    static List<Integer>[] graph;
    static StringTokenizer st;
    static boolean[] visited;
    static final int zombie = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vertex = Integer.parseInt(br.readLine());
        Edge = Integer.parseInt(br.readLine());
        graph = new List[Vertex + 1];

        for (int v = 1; v <= Vertex; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < Edge; e++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        visited = new boolean[Vertex + 1];

        System.out.println(bfs());
    }

    public static int bfs() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(zombie);
        visited[zombie] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    count++;
                    visited[next] = true;
                }
            }
        }
        return count;
    }
}