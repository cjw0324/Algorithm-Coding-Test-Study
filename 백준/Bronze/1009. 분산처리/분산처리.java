
import java.io.*;
import java.util.*;
public class Main {
    static int[] mod;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mod = new int[4];
            mod[0] = a % 10;
            for (int j = 1; j < 4; j++) {
                mod[j] = (mod[j - 1] * a) % 10;
            }
            int index = b % 4 - 1;
            index = index == -1 ? 3 : index;
            int answer = mod[index] == 0 ? 10 : mod[index];
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
