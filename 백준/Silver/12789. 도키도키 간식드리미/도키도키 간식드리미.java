import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] students = new int[n];
        for (int i = 0; i<n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        Deque <Integer> stack = new LinkedList<>();
        int nextNumber = 1;
        for (int num : students) {
            if (num != nextNumber) {
                stack.offerFirst(num);
            } else {
                nextNumber++;
            }
            while(!stack.isEmpty() && stack.peekFirst() == nextNumber) {
                stack.pollFirst();
                nextNumber++;
            }
        }

        if(stack.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }

}