import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        System.out.println(money > 0 ? money : 0);
    }
}