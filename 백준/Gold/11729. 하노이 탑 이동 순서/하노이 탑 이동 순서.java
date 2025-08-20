import java.io.*;
import java.util.*;
public class Main {
    static int count;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n,1,2,3);
        StringBuffer answer = new StringBuffer();
        answer.append(count).append("\n").append(sb);

        System.out.println(answer.toString().trim());

    }

    static void hanoi(int n, int from, int temp, int to){
        count++;
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        } else {
            hanoi(n-1, from, to, temp);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(n-1, temp, from, to);
        }
    }
}