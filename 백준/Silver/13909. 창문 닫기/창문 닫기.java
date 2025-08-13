import java.io.*;
import java.util.*;
public class Main {
    static final int max = 2_100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i*i<=max; i++) {
            int start = i*i;
            int end = start + i * 2;
            if (n >= start && n <= end) {
                System.out.println(i);
                break;
            }
        }
    }
}