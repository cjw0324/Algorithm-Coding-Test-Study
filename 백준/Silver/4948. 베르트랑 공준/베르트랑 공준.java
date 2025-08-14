import java.io.*;
import java.util.*;
public class Main {
    static boolean visited[] = new boolean[246913];
    public static void main(String[] args) throws IOException {

        for (int i = 0; i * i <= visited.length; i++) {
            if (i<2) visited[i] = true;
            else {
                if (!visited[i]) {
                    for (int p = i * i; p<= visited.length; p+=i) {
                        visited[p] = true;
                    }
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n!=0) {
            int count = 0;
            for (int i = n+1; i<=n*2; i++) {
                if(!visited[i]) count++;
            }
            System.out.println(count);
            n = Integer.parseInt(br.readLine());
        }
    }

}