import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static char[][] map;
    static BufferedReader br;
    static List<Node> nodes;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Vertex> vertexes;
    static int[] parent;

    static class Node {
        int x;
        int y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    static class Vertex {
        int start;
        int end;
        int cost;
        public Vertex(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        nodes = new ArrayList<>();
        input();
        int answer = getShortestDistance();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        fillMap();
    }

    private static void fillMap() throws IOException {
        map = new char[n][n];
        for (int row = 0; row < n; row++) {
            char[] line = br.readLine().toCharArray();
            for (int col = 0; col < n; col++) {
                map[row][col] = line[col];

                if (map[row][col] == 'S' || map[row][col] == 'K') {
                    nodes.add(new Node(row, col, 0));
                }
            }
        }
    }

    private static int getShortestDistance() {
        vertexes = new PriorityQueue<>((v1, v2) -> v1.cost - v2.cost);
        for (int start = 0; start < m + 1; start++) {
            bfs(start);
        }

        return kruskal();
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(start));
        visited = new boolean[n][n];
        visited[nodes.get(start).x][nodes.get(start).y] = true;
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == '1' || visited[nx][ny]) continue;
                if (map[nx][ny] == 'S' || map[nx][ny] == 'K') {
                    for (int index = 0; index < m + 1; index++) {
                        if (index != start && nodes.get(index).x == nx && nodes.get(index).y == ny) {
                            vertexes.add(new Vertex(start, index, now.dis + 1));
                            break;
                        }
                    }
                }
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, now.dis + 1));
            }
        }
    }

    private static int kruskal() {
        parent = new int[m + 1];
        for (int i = 0; i < m + 1; i++) {
            parent[i] = i;
        }

        int totalDis = 0;
        int edgeCount = 0;
        while (!vertexes.isEmpty()) {
            Vertex now = vertexes.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                totalDis += now.cost;
                edgeCount++;
            }
        }

        if (edgeCount != m) return -1;
        return totalDis;
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

}
