import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        // 초기 세팅
        int[][] memo = new int[s.length() + 1]['z' - 'a' + 1];

        for (int x = 1; x <= s.length(); x++) {
            for (int y = 0; y < ('z' - 'a' + 1); y++) {
                memo[x][y] = memo[x-1][y];
            }
            char c = s.charAt(x - 1);
            memo[x][c - 'a']++;
        }


        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < q; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            int big = memo[j + 1][c - 'a'];
            int small = memo[i][c - 'a'];

            sb.append(big - small).append("\n");
        }

        System.out.println(sb.toString().trim());

    }
}
