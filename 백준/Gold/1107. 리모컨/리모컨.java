import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] buttons;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        buttons = new boolean[10];
        Arrays.fill(buttons, true);

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                int broken = Integer.parseInt(st.nextToken());
                buttons[broken] = false;
            }
        }



        if (n == 100) {
            System.out.println(0);
            return;
        }

        int answer = Math.abs(n - 100);

        for (int i = 0; i <= 999_999; i++) {
            char[] arr = Integer.toString(i).toCharArray();
            boolean available = true;
            for (char c : arr) {
                if (!buttons[c - '0']) {
                    available = false;
                    break;
                }
            }
            if (available) {
                answer = Math.min(answer, arr.length + Math.abs(n - i));
            }
        }

        System.out.println(answer);
    }
}