import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(time, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });


        int answer = 0;
        int now = 0;
        for (int[] t : time) {
            if (now <= t[0]) {
                answer++;
                now = t[1];
            }
        }
        System.out.println(answer);
    }
}