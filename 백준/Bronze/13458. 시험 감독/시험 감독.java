import java.io.*;
import java.util.*;
public class Main {
    static int n,b,c;
    static int[] arr;
    static long answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        answer = n;

        for (int i = 0; i < n; i++) {
            long remain = arr[i] - b;
            if (remain > 0) {
                answer += remain / c;
                if (remain % c != 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}