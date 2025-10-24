import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map.put(136, 0);
        map.put(142, 0);
        map.put(148, 0);
        map.put(154, 0);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            map.put(w, map.get(w) + 1);
        }

        int totalPrice = 0;
        totalPrice += (map.get(136) * 1000);
        totalPrice += (map.get(142) * 5000);
        totalPrice += (map.get(148) * 10000);
        totalPrice += (map.get(154) * 50000);

        System.out.println(totalPrice);

    }


}