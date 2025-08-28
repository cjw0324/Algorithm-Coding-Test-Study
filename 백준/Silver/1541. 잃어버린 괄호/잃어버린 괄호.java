import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        List<Integer> list = new ArrayList<>();

        int size = st.countTokens();
        for (int i = 0; i < size; i++) {
            list.add(getSum(st.nextToken()));
        }

        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                answer = list.get(i);
            } else {
                answer -= list.get(i);
            }
        }
        System.out.println(answer);

    }


    static int getSum(String s) {

        String[] nums = s.split("\\+");
        int sum = 0;
        for (String str : nums) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }
}