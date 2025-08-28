import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer
                = new StringTokenizer(bufferedReader.readLine(), " ");
        int count = 0;
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(bufferedReader.readLine(), 0);
        }
        for (int i = 0; i < m; i++) {
            if (hashMap.containsKey(bufferedReader.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}