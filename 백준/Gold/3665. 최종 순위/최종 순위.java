import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static int[] degree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int CASE = Integer.parseInt(br.readLine());

        for (int c = 0; c < CASE; c++) {
            n = Integer.parseInt(br.readLine());
            graph = new List[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] list = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            degree = new int[n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[list[i]].add(list[j]);
                }

                degree[list[i]] = n - 1 - graph[list[i]].size();
            }

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                Integer a = Integer.parseInt(st.nextToken());
                Integer b = Integer.parseInt(st.nextToken());

                if (graph[b].contains(a)) {
                    graph[b].remove(a);
                    degree[b]++;
                    graph[a].add(b);
                    degree[a]--;
                } else {
                    graph[a].remove(b);
                    degree[a]++;
                    graph[b].add(a);
                    degree[b]--;
                }

            }

            sb.append(topologySort());
        }
        System.out.println(sb.toString().trim());
    }

    static String topologySort() {
        StringBuilder temp = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }


        for (int i = 1; i <= n; i++) {
            if (queue.size() > 1) {
                return "?\n";
            }
            if (queue.isEmpty()) {
                return "IMPOSSIBLE\n";
            }

            int now = queue.poll();
            temp.append(now).append(" ");
            for (int next : graph[now]) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return temp.append("\n").toString();
    }

}