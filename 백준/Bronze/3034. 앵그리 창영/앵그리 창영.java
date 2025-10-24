import java.io.*;
import java.util.*;
public class Main {
    static int n, w, h;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        double max = Math.sqrt(Math.pow(h, 2) + Math.pow(w, 2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (max < Double.parseDouble(br.readLine())) {
                sb.append("NE\n");
            } else {
                sb.append("DA\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}