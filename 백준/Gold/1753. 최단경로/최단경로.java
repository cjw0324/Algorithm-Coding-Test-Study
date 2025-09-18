import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int v, e, k;
    static boolean[] visited;
    static List<Node>[] list;
    static int[] dpTable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        list = new List[v + 1];
        visited = new boolean[v + 1];
        dpTable = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
            dpTable[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        dpTable[k] = 0;
        pq.offer(new Node(k, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.end]) visited[now.end] = true;

            for (int i = 0; i < list[now.end].size(); i++) {
                Node next = list[now.end].get(i);

                if (!visited[next.end] && now.weight + next.weight < dpTable[next.end]) {
                    dpTable[next.end] = now.weight + next.weight;
                    pq.offer(new Node(next.end, dpTable[next.end]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dpTable[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dpTable[i]).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}