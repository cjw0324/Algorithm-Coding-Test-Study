import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            String star = "*";
            String empty = " ";
            String temp = "";
            temp += empty.repeat(n - i);
            temp += star.repeat(i);
            sb.append(temp).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
