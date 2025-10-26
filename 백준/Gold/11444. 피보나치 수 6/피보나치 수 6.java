import java.io.*;
import java.util.*;

public class Main {
    static long MOD = 1_000_000_007;
    static long[][] init = {{1,1},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] A = {{1,1},{1,0}};

        long N = Long.parseLong(br.readLine());

        A = pow(A, N - 1);
        System.out.println(A[0][0]);
    }

    static long[][] pow(long[][] A, long exp) {
        if(exp == 1 || exp == 0) {
            return A;
        }

        long[][] res = pow(A, exp / 2);

        res = multiply(res, res);

        if (exp % 2 == 1) {
            res = multiply(res, init);
        }

        return res;
    }

    static long[][] multiply(long[][] A, long[][] B) {
        int N = A.length;
        int M = A[0].length;
        int K = B[0].length;
        long[][] C = new long[N][K];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<K; j++) {
                for (int k = 0; k < M; k++) {
                    C[i][j] += (A[i][k] * B[k][j]);
                    C[i][j] %= MOD;
                }
            }
        }
        return C;
    }
}