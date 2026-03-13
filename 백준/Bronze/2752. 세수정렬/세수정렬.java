import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[3];
        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken());
        nums[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
    }
}