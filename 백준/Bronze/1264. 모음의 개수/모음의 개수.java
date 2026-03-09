
import java.io.*;
import java.util.*;

public class Main {
    static Set<Character> moeum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        moeum = new HashSet<>();
        moeum.add('a');
        moeum.add('A');
        moeum.add('e');
        moeum.add('E');
        moeum.add('i');
        moeum.add('I');
        moeum.add('o');
        moeum.add('O');
        moeum.add('u');
        moeum.add('U');

        while (true) {
            char[] chars = br.readLine().toCharArray();
            if (chars[0] == '#') {
                break;
            }
            int count = 0;
            for (char c : chars) {
                if (moeum.contains(c)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
