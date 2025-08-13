import java.io.*;
import java.util.*;
public class Main {
    static final int max = 1_000_000;
    static boolean[] visited = new boolean[max + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        sieve();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i<t; i++){
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j<= n/2; j++) {
                if (!visited[j] && !visited[n - j]) count++;
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void sieve() {
        visited[0] = true;
        visited[1] = true;

        for (int i = 2; i * i<= max; i++){
            if (!visited[i]) {
                for(int p = i*i; p<= max; p+=i) {
                    visited[p] = true;
                }
            }
        }
    }

}