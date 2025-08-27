import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[n + 1];
        sum[n] = Arrays.stream(arr).sum();
        for (int i = n - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] - arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sum[j] - sum[i - 1]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}