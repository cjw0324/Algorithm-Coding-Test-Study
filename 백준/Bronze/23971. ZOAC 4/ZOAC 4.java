import java.io.*;
import java.util.*;

public class Main {
    static int h,w,n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int row = h / (1 + n);
        if (h % (1 + n) != 0) {
            row++;
        }

        int col = w / (1 + m);
        if (w % (1 + m) != 0) {
            col++;
        }

        System.out.println(row * col);
    }
}