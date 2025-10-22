import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[] arr;
    static long[] tree;
    static final int INF = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];
        tree = new long[n * 4];
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, n - 1, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(0, n - 1, 1, b- 1, c);
            }
            if (a == 2) {
                long m = multiply(0, n - 1, 1, b - 1, c - 1);
                sb.append(m).append("\n");
            }
        }

        System.out.println(sb.toString().trim());


    }

    static long multiply(int start, int end, int index, int left, int right) {
        if (right < start || end < left) {
            return 1;
        }
        if (left <= start && end <= right) {
            return tree[index];
        }

        int mid = (start + end) / 2;
        return (multiply(start, mid, index * 2, left, right) *
                multiply(mid + 1, end, index * 2 + 1, left, right)) % INF;

    }

    static void update(int start, int end, int index, int what, int value) {
        if (what < start || end < what) {
            return;
        }
        if (start == end) {
            tree[index] = value % INF;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, index * 2, what, value);
        update(mid + 1, end, index * 2 + 1, what, value);
        tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % INF;
    }


    static long init(int start, int end, int index) {
        if (start == end) {
            return tree[index] = arr[start] % INF;
        }

        int mid = (start + end) / 2;
        tree[index] = (init(start, mid, index * 2) * init(mid + 1, end, index * 2 + 1)) % INF;
        return tree[index];
    }
}
