import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            long num = Long.parseLong(br.readLine());
            sb.append(prime(num)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static long prime(long num){
        while(true) {
            if (num < 2) {
                num++;
            } else {
                if (BigInteger.valueOf(num).isProbablePrime(20)) {
                    break;
                } else {
                    num++;
                }
            }

        }
        return num;
    }

}