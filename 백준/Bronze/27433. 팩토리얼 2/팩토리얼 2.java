import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());

        System.out.println(pactorial(n));

    }

    public static long pactorial (long n) {
        if (n == 0) return 1;
        else {
            return pactorial(n-1) * n;
        }
    }


}