import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }

            long max = getSub(0, n - 1);
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static long getSub(int lt, int rt) {
        if (lt == rt) {
            return h[lt];
        }
        int mid = (lt + rt) / 2;
        long left = getSub(lt, mid);
        long right = getSub(mid + 1, rt);

        long max = Math.max(left, right);

        max = Math.max(max, getMid(lt, rt, mid));

        return max;
    }

    private static long getMid(int leftEnd, int rightEnd, int mid) {
        int left = mid;
        int right = mid;

        long height = h[mid];
        long maxArea = height;

        while (leftEnd < left && right < rightEnd) {
            if (h[left - 1] > h[right + 1]) {
                left--;
                height = Math.min(height, h[left]);
            } else {
                right++;
                height = Math.min(height, h[right]);
            }

            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }

        while (right < rightEnd) {
            right++;
            height = Math.min(height, h[right]);
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }

        while (left > leftEnd) {
            left--;
            height = Math.min(height, h[left]);
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }

        return maxArea;
    }
}
