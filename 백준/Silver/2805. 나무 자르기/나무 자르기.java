import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] trees;
    static int h = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int rt = Arrays.stream(trees).max().getAsInt();
        int lt = 0;

        while (rt >= lt) {
            int mid = (rt + lt) / 2;
            long getTree = cutting(mid);
            if (getTree < m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                h = mid;
            }
        }
        System.out.println(h);
    }


    public static long cutting(int h) {  // 반환형 long
        long result = 0; // 누적합 long
        for (int t : trees) {
            int cut = t - h;
            if (cut > 0) result += cut;  // >= 0 보다는 > 0이 더 자연스러움
        }
        return result;
    }

}