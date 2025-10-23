
import java.io.*;
import java.util.*;
public class Main {
    static char[][] files;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        files = new char[T][50];
        for (int i = 0; i < T; i++) {
            files[i] = br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files[0].length; i++) {
            if (check(i)) {
                sb.append(files[0][i]);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb.toString().trim());

    }

    static boolean check(int index) {
        for (int i = 0; i < T; i++) {
            for (int j = i + 1; j < T; j++) {
                if (files[i][index] != files[j][index]) return false;
            }
        }
        return true;
    }
}
