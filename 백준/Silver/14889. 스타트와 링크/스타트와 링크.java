import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] nums;
    static int diff = Integer.MAX_VALUE;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selected = new boolean[n];
        nums = new int[n][n];

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        System.out.println(diff);
    }

    static void dfs(int idx, int count) {
        if (count == n / 2) {
            calculateDiff();
            return;
        }

        for (int i = idx; i<n; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    static void calculateDiff() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // selected 배열을 직접 사용하여 O(1) 시간에 확인
                if (selected[i] && selected[j]) {
                    startScore += nums[i][j];
                } else if (!selected[i] && !selected[j]) {
                    linkScore += nums[i][j];
                }
            }
        }

        diff = Math.min(diff, Math.abs(startScore - linkScore));
    }
}
