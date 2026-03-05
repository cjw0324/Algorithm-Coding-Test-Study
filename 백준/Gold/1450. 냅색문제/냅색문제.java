import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static List<Integer> item1, item2;
    static List<Long> subset1, subset2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        item1 = new ArrayList<>();
        item2 = new ArrayList<>();
        subset1 = new ArrayList<>();
        subset2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i < N / 2) {
                item1.add(Integer.parseInt(st.nextToken()));
            } else {
                item2.add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(subset1, item1, 0, 0);
        dfs(subset2, item2, 0, 0);

        Collections.sort(subset1);
        Collections.sort(subset2);

        int answer = 0;

        for (long base : subset1) {
            answer += binarySearch(base);
        }

        System.out.println(answer);
    }

    private static int binarySearch(long base) {
        int lt = 0;
        int rt = subset2.size() - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long sum = subset2.get(mid) + base;
            if (sum > C) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    private static void dfs(List<Long> save, List<Integer> items, int depth, long sum) {
        if (depth == items.size()) {
            save.add(sum);
            return;
        }

        dfs(save, items, depth + 1, sum);
        dfs(save, items, depth + 1, sum + items.get(depth));
    }
}
