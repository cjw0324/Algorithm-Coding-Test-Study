import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);
        int lt = 0;
        int rt = N - 1;
        int l = lt;
        int r = rt;
        int min = Integer.MAX_VALUE;
        while(lt < rt) {
            int sum = liquids[lt] + liquids[rt];
            if (Math.abs(sum) < Math.abs(min)) {
                l = lt;
                r = rt;
                min = sum;
            }
            if (sum < 0) {
                lt++;
                continue;
            }
            if (sum > 0) {
                rt--;
                continue;
            }
            break;
        }

        System.out.println(liquids[l] + " " + liquids[r]);
    }
}
