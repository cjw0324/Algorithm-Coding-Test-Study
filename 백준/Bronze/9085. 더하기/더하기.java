import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}