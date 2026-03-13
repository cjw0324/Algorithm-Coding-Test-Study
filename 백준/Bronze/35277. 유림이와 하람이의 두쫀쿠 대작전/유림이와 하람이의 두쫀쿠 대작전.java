import java.io.*;

public class Main {
    static final int totalCost = 900 + 60 + 600 + 170 + 160 + 110;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine()) / totalCost);
    }
}