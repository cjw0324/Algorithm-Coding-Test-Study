import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] sequence;
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequence = new int[n];
        LIS = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = sequence[0];
        int index = 0;

        for (int i = 1; i < n; i++) {
            int num = sequence[i];

            if (LIS[index] < num) {
                index++;
                LIS[index] = num;
            }

            else {
                int lt = 0;
                int rt = index;
                while(lt < rt) {
                    int mid = (lt + rt) / 2;
                    if (LIS[mid] < num) {
                        lt = mid + 1;
                    } else {
                        rt = mid;
                    }
                }
                LIS[lt] = num;
            }

        }
        System.out.println(index + 1);
    }
}