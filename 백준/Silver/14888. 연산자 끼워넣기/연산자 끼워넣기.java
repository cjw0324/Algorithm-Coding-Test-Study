import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] nums;
    static int[] calc = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int num) {
        if (depth == n) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        if (depth == 0) {
            dfs(1, nums[0]);
            return;
        }

        for (int i = 0; i<4; i++) {
            if (calc[i] != 0) {
                calc[i]--;
                if (i == 0) { // +
                    dfs(depth + 1, num + nums[depth]);
                } else if (i == 1) { // -
                    dfs(depth + 1, num - nums[depth]);
                } else if (i == 2) { // *
                    dfs(depth + 1, num * nums[depth]);
                } else { // /
                    if (nums[depth] != 0) {
                        dfs(depth + 1, num / nums[depth]);
                    }
                }
                calc[i]++;
            }
        }

    }
}