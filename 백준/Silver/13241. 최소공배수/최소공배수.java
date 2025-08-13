import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(a * b / gcd(a, b));
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