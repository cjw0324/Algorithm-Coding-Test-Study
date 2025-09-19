import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int lt = 0;
        int rt = n - 1;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == x) {
                answer++;
                lt++;
                rt--;
            } else if (sum < x) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(answer);
    }

}