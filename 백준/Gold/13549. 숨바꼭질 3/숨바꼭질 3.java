import java.io.*;
import java.util.*;
public class Main {
    static int n, k;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {2, -1, 1};
    static boolean[] visited = new boolean[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));
        visited[n] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int time = now.time;

//            System.out.println("x : " + x + ", time : " + time);

            if (x == k) {
                answer = Math.min(answer, time);
                break;
            }


            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = x * dx[i];
                } else {
                    nx = x + dx[i];
                }

                if (nx >= 0 && nx <= 100_000 && !visited[nx]) {
                    visited[nx] = true;
                    if (i > 0) {
                        queue.offer(new Node(nx, time + 1));
                    } else {
                        queue.offer(new Node(nx, time));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}