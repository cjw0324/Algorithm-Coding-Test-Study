import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        calc(0, n - 1);
        System.out.println(answer);
    }

    static int calc(int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        int head = calc(start, mid);
        int tail = calc(mid + 1, end);
        answer += (head * tail);
        return head + tail;

    }
}