import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long length = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            length += arr[i];
        }

        for (int i = 0; i < n; i++) {
            long temp = arr[i];
            length -= temp;
            answer += temp * length;
        }

        System.out.println(answer);
    }
}
