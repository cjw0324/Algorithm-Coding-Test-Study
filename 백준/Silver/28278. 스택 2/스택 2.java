import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> stack = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            if (input.equals("1")) {
                one(Integer.parseInt(st.nextToken()));
            } else if (input.equals("2")) {
                two();
            } else if (input.equals("3")) {
                three();
            } else if (input.equals("4")) {
                four();
            } else {
                five();
            }
        }

        System.out.println(sb);
    }



    static void one(int x) { //x를 넣는다
         stack.offerFirst(x);
    }

    static void two() { //poll 할 수 있으면 poll 하고 출력, 불가하면 -1 출력
        if(stack.isEmpty()) sb.append("-1").append("\n");
        else {
            sb.append(stack.pollFirst()).append("\n");
        }
    }

    static void three() { //stack 크기 출력
        sb.append(stack.size()).append("\n");
    }

    static void four() { //stack 이 비어있으면 1, 아니면 0 출력
        if(stack.isEmpty()) sb.append("1").append("\n");
        else {
            sb.append(0).append("\n");
        }
    }

    static void five() { //stack peek() 값 출력, 불가하면 -1 출력
        if(stack.isEmpty()) sb.append("-1").append("\n");
        else {
            sb.append(stack.peekFirst()).append("\n");
        }
    }
}