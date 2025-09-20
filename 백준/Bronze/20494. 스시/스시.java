import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] character = new int[26];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (char c : arr) {
                character[c - 'A']++;
            }
        }

        for (int i : character) {
            answer += i;
        }

        System.out.println(answer);

    }
}