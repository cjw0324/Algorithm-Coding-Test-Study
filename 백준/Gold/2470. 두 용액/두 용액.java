import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int lt = 0;
        int rt = n - 1;
        int l1 = 0, l2 = 0;
        int max = Integer.MAX_VALUE;

        while (lt < rt) {
            int sum = nums[lt] + nums[rt];
            if (max > Math.abs(sum)) {
                l1 = nums[lt];
                l2 = nums[rt];
                max = Math.abs(sum);
            }

            if (sum > 0) {
                rt--;
            }

            if (sum < 0) {
                lt++;
            }

            if (sum == 0) {
                break;
            }
        }

        System.out.println(l1 + " " + l2);
    }
}