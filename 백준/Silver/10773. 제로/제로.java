import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pollFirst();
            } else {
                stack.offerFirst(num);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pollFirst();
        }

        System.out.println(sum);
    }
}