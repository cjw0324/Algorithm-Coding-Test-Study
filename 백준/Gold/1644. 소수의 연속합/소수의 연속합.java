import java.io.*;
import java.util.*;


/**
 * 1. 1부터 입력받은 수 까지의 소수 배열 생성
 */

public class Main {
    static int N;
    static boolean[] isPrime;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        makePrimeList();

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while (start <= end && end < list.size()) {
            if (sum < N) {
                sum += list.get(end++);
            } else {
                if (sum == N) {
                    cnt++;
                }
                sum -= list.get(start++);
            }
        }

        System.out.println(cnt);
    }

    static void makePrimeList() {
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }
        list.add(0);
    }
}