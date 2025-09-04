import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int n;
    static int k;
    static int l;
    static int time = 0;
    static int beforeDir = 3;
    static PriorityQueue<Order> pq = new PriorityQueue<>();
    static Deque<Point> snake = new ArrayDeque<>();
    // 방향 벡터 (0:상, 1:하, 2:좌, 3:우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new char[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(board[i], ' ');
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || i == n + 1 || j == 0 || j == n + 1) {
                    board[i][j] = '#';
                }
            }
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 'A';
        }




        l = Integer.parseInt(br.readLine());



        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Order(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        play();

    }

    static void play() {
        board[1][1] = 'O';
        snake.offerFirst(new Point(1, 1));

        while (true) {
            time++;

            Point head = snake.peekFirst();
            Point tail = snake.peekLast();

            if (!move(beforeDir, head, tail)) {
                System.out.println(time);
                return;
            }

            if (!pq.isEmpty() && pq.peek().time == time) {
                Order order = pq.poll();
                beforeDir = turn(beforeDir, order.dir);
            }
        }
    }

    static int turn(int dir, boolean rightTurn) {
        if (rightTurn) {
            if (dir == 0) return 3; // 상 -> 우
            if (dir == 3) return 1; // 우 -> 하
            if (dir == 1) return 2; // 하 -> 좌
            return 0;
        } else {
            if (dir == 0) return 2; // 상 -> 좌
            if (dir == 1) return 3; // 하 -> 우
            if (dir == 2) return 1; // 좌 -> 하
            return 0;
        }
    }

    // dir 방향으로 한 칸 이동. 충돌 시 false
    static boolean move(int dir, Point head, Point tail) {
        int nx = head.x + dx[dir];
        int ny = head.y + dy[dir];

        // 벽 충돌 체크
        if (checkEndGame(new Point(nx, ny))) return false;

        char nextCell = board[nx][ny];
        boolean apple = (nextCell == 'A');

        // 자기 몸과의 충돌 체크
        // 단, 이번 턴에 사과를 먹지 않고 꼬리가 빠질 자리로 들어가는 것은 허용
        if (nextCell == 'O') {
            return false;
        }

        // 머리 전진
        snake.addFirst(new Point(nx, ny));
        board[nx][ny] = 'O';

        // 사과가 없으면 꼬리 제거(이동)
        if (!apple) {
            Point removed = snake.removeLast();
            board[removed.x][removed.y] = ' ';
        }
        // 사과면 그대로(몸 길이 +1). 보드는 이미 'O'로 덮였으니 추가 처리 불필요

        return true;
    }

    static boolean checkEndGame(Point point) {
        return point.x == 0 || point.x == n + 1 || point.y == 0 || point.y == n + 1;
    }



    static class Order implements Comparable<Order> {
        int time;
        boolean dir; // true : D (오른쪽), false : L (왼쪽)

        public Order(int t, char c) {
            this.time = t;
            dir = (c == 'D');
        }

        @Override
        public int compareTo(Order o) {
            return this.time - o.time;
        }
    }
}