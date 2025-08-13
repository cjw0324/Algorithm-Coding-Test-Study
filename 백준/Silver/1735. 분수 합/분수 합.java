import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        long up = a * d + b * c;
        long down = b * d;

        long GCD = gcd(up, down);

        System.out.println(up / GCD +" "+ down / GCD);
    }

    public static long gcd(long a,long b) {
        while(b!=0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}