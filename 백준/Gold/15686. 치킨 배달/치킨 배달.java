import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static List<Point> house;
    static List<Point> chicken;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    house.add(new Point(i, j));
                }
                if (type == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        DFS(0, 0);

        System.out.println(min);

    }

    static int dist(int index) {
        int distance = Integer.MAX_VALUE;
        int cx = house.get(index).x;
        int cy = house.get(index).y;

        for (int i = 0; i<chicken.size(); i++) {
            if (visited[i]) {
                Point p = chicken.get(i);
                distance = Math.min(distance, Math.abs(cx - p.x) + Math.abs(cy - p.y));
            }
        }
        return distance;
    }

    static void DFS(int start, int cnt) {
        if (cnt == m) {
            int distance = 0;
            for (int i = 0; i < house.size(); i++) {
                distance += dist(i);
            }
            min = Math.min(min, distance);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            visited[i] = true;
            DFS(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
