import java.io.*;
import java.util.*;

public class Main {
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        int length = 64;
        int stick = 64;
        int count = 1;
        int c = 0;
        while (length != X) {
            stick /= 2;
            length -= stick;
            if (length < X) {
                count++;
                length += stick;
            }
        }

        System.out.println(count);
    }
}