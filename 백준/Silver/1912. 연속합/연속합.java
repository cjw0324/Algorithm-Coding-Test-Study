import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        memo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo[0] = arr[0];

        for (int i = 1; i < n; i++) {
            memo[i] = Math.max(memo[i - 1] + arr[i], arr[i]);
        }

        System.out.println(Arrays.stream(memo).max().getAsInt());
    }


}