import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        char[] original = str.toCharArray();
        char[] upper = str.toUpperCase().toCharArray();
        char[] lower = str.toLowerCase().toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (original[i] != upper[i]) {
                sb.append(upper[i]);
            } else {
                sb.append(lower[i]);
            }
        }

        System.out.println(sb);
    }
}