import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int students = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= students / a; i++) {
            for (int j = 0; j <= students / b; j++) {
                for (int k = 0; k <= students / c; k++) {
                    if (a * i + b * j + c * k == students) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);


    }
}