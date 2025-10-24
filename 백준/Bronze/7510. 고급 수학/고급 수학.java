import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int slope = arr[2];
            sb.append("Scenario #" + (i + 1) + ":\n");
            if (Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) == slope) {
                sb.append("yes\n\n");
            } else {
                sb.append("no\n\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}