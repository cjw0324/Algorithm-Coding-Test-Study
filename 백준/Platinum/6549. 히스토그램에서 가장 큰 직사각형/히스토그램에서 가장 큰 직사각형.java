import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] histogram;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            histogram = new int[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getMaxArea(0,n-1)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    private static long getMaxArea(int left, int right) {
        if (left == right) {
            return histogram[left];
        }

        int mid = (left + right) / 2;
        long maxArea = Math.max(getMaxArea(left, mid), getMaxArea(mid + 1, right));

        maxArea = Math.max(maxArea, getMidArea(left, mid, right));

        return maxArea;
    }

    private static long getMidArea(int maxLeft, int mid, int maxRight) {
        long height = histogram[mid];
        long area = height;
        int moveLeft = mid, moveRight = mid;

        while (maxLeft < moveLeft && moveRight < maxRight) {
            if (histogram[moveLeft - 1] < histogram[moveRight + 1]) {
                moveRight++;
                height = Math.min(height, histogram[moveRight]);
            } else {
                moveLeft--;
                height = Math.min(height, histogram[moveLeft]);
            }
            area = Math.max(area, (moveRight - moveLeft + 1) * height);
        }

        while (maxLeft < moveLeft) {
            moveLeft--;
            height = Math.min(height, histogram[moveLeft]);
            area = Math.max(area, (moveRight - moveLeft + 1) * height);
        }

        while (moveRight < maxRight) {
            moveRight++;
            height = Math.min(height, histogram[moveRight]);
            area = Math.max(area, (moveRight - moveLeft + 1) * height);
        }

        return area;
    }
}
