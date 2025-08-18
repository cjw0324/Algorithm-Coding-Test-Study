import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i<n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);

        double avgTemp = Arrays.stream(input).sum();
        sb.append((int) Math.round(avgTemp / (double) n )).append("\n");

        sb.append(input[n/2]).append("\n");

        //중앙값 구하기
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : input) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        for (int count : map.values()) {
            maxCount = Math.max(count, maxCount);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                list.add(key);
            }
        }

        if (list.size() == 1) {
            sb.append(list.get(0)).append("\n");
        } else {
            Collections.sort(list);
            sb.append(list.get(1)).append("\n");
        }
        sb.append(input[n-1] - input[0]);

        System.out.println(sb.toString().trim());
    }
}
