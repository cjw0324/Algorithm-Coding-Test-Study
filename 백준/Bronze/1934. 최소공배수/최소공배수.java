import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i< t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a * b / gcd(a,b)).append("\n");
        }
        System.out.println(sb);

    }

    public static int gcd(int a, int b) {
        while (b!=0){
            int t = a%b;
            a= b;
            b= t;
        }
        return a;
    }
}