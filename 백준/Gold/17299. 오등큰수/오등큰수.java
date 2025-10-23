import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            arr[i] = num;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] != arr[i] && map.get(arr[stack.peek()]) < map.get(arr[i]) ) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
