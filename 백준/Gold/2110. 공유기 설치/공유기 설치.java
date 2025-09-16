
import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static int[] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int lt = 1;
        int rt = houses[n - 1] - houses[0];
        int answer = 0;

        while (rt >= lt) {
            int mid = (rt + lt) / 2;
            int position = 0;
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (houses[i] - houses[position] >= mid) {
                    count++;
                    position = i;
                }
            }

            if (count >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}