import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();


        int num = Integer.parseInt(br.readLine());

        while(num != 0){
            boolean[] visited = new boolean[2 * num + 1];
            for (int i = 0; i * i <= 2 * num; i++) {
                if (i<2) visited[i] = true;
                else {
                    if (!visited[i]) {
                        for (int p = i * i; p <= 2 * num; p+=i){
                            visited[p] = true;
                        }
                    }
                }
            }
            int count = 0;
            for (int i = num + 1; i<= 2* num; i++) {
                if(!visited[i]) count++;
            }

            sb.append(count).append("\n");

            num = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }

}