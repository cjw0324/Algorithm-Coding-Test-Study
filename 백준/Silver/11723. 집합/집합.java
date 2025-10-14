import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            if (command.equals("add")) {
                set.add(num);
            } else if (command.equals("check")) {
                if (set.contains(num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("remove")) {
                if (set.contains(num)) {
                    set.remove(num);
                }
            } else if (command.equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (command.equals("all")) {
                set = new HashSet<>();
                for (int d = 1; d <= 20; d++) {
                    set.add(d);
                }
            } else {
                set = new HashSet<>();
            }
        }

        System.out.println(sb.toString().trim());
    }
}