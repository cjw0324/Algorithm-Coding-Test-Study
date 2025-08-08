import java.io.*;
import java.util.*;

public class Main {
    static class Car implements Comparable<Car> {
        int pos, fuel, id;

        Car(int pos, int fuel, int id) {
            this.pos = pos;
            this.fuel = fuel;
            this.id = id;
        }

        public int compareTo(Car o) {
            return Integer.compare(this.pos, o.pos);
        }
    }

    static int n, s;
    static Car[] cars;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()) - 1;

        cars = new Car[n];
        visited = new boolean[n];

        int[] posArr = new int[n];
        int[] fuelArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) posArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) fuelArr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(posArr[i], fuelArr[i], i);
        }

        Arrays.sort(cars); // 위치 기준 정렬

        int startIdx = -1;
        for (int i = 0; i < n; i++) {
            if (cars[i].id == s) {
                startIdx = i;
                break;
            }
        }

        bfsExpand(startIdx);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) result.add(cars[i].id + 1); // 1-based
        }

        Collections.sort(result);
        for (int x : result) {
            bw.write(x + " ");
        }
        bw.newLine();
        bw.flush();
    }

    static void bfsExpand(int sIdx) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[sIdx] = true;
        queue.offer(sIdx);

        int minIdx = sIdx;
        int maxIdx = sIdx;
        int minPos = cars[sIdx].pos;
        int maxPos = cars[sIdx].pos;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curPos = cars[cur].pos;
            int fuel = cars[cur].fuel;

            minPos = Math.min(minPos, curPos - fuel);
            maxPos = Math.max(maxPos, curPos + fuel);

            while (minIdx - 1 >= 0 && cars[minIdx - 1].pos >= minPos) {
                minIdx--;
                if (!visited[minIdx]) {
                    visited[minIdx] = true;
                    queue.offer(minIdx);
                }
            }

            while (maxIdx + 1 < n && cars[maxIdx + 1].pos <= maxPos) {
                maxIdx++;
                if (!visited[maxIdx]) {
                    visited[maxIdx] = true;
                    queue.offer(maxIdx);
                }
            }
        }
    }
}
