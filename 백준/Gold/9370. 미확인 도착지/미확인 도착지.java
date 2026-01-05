import java.io.*;
import java.util.*;

public class Main {
    static List<Edge>[] graph;
    static int T;
    static int n, m, t, s, g, h;
    static int[] targets;
    static int[] originalDistances;
    static int essentialRoute = 0;
    static List<Integer> answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            answer = new ArrayList<>();
            init();
            calcRoute(s, originalDistances);
            Node stopover = stopoverDistance();
            int[] stopoverDistances = new int[n + 1];
            Arrays.fill(stopoverDistances, Integer.MAX_VALUE);
            essentialRoute += originalDistances[stopover.start];
            stopoverDistances[stopover.end] = 0;
            calcRoute(stopover.end, stopoverDistances);
            for (int target : targets) {
                if (originalDistances[target] == stopoverDistances[target] + essentialRoute) {
                    answer.add(target);
                }
            }

            Collections.sort(answer);
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static Node stopoverDistance() {
        if (originalDistances[g] > originalDistances[h]) {
            return new Node(h, g);
        }
        return new Node(g, h);
    }


    static void calcRoute(int start, int[] distances) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int node = now.node;
            int distance = now.distance;
            for (Edge edge : graph[node]) {
                int nextNode = edge.node;
                int cost = edge.distance;
                if (distances[nextNode] > distance + cost) {
                    distances[nextNode] = distance + cost;
                    queue.offer(new Edge(nextNode, distances[nextNode]));
                }
            }
        }
    }


    static void init() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int node = 0; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }
        targets = new int[t];
        originalDistances = new int[n + 1];
        Arrays.fill(originalDistances, Integer.MAX_VALUE);
        originalDistances[s] = 0;

        for (int road = 0; road < m; road++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, d));
            graph[b].add(new Edge(a, d));

            if ((a == g && b == h) || (a == h && b == g)) {
                essentialRoute = d;
            }
        }

        for (int target = 0; target < t; target++) {
            targets[target] = Integer.parseInt(br.readLine());
        }
    }

    static class Edge {
        int node;
        int distance;

        public Edge(int n, int d) {
            this.node = n;
            this.distance = d;
        }
    }

    static class Node {
        int start;
        int end;

        public Node(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
}