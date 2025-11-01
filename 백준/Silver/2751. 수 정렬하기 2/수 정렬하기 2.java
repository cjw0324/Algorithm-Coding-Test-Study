import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(buffer.readLine()));
        }
        buffer.close();

        Collections.sort(arr);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            stringBuilder.append(arr.get(i)).append("\n");
        }
        System.out.println(stringBuilder);
        
    }
}