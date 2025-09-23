import java.io.*;
import java.util.*;
public class Main {
    static int n, s;
    static int answer = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] visited = new boolean[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            while (sum >= s) {
                answer = Math.min(answer, rt - lt + 1);
                sum -= arr[lt++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}