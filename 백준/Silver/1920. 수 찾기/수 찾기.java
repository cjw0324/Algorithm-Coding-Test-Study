import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arrM;
    static int[] arrN;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        arrM = new int[m];
        st = new StringTokenizer(br.readLine(), " ");

        Arrays.sort(arrN);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int answer = isContain(Integer.parseInt(st.nextToken())) ? 1 : 0;
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isContain(int x) {
        int l = 0;
        int r = n - 1;
        boolean contain = false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arrN[mid] == x) {
                contain = true;
                return contain;
            }
            if (x < arrN[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return contain;
    }
}