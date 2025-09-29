import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long b;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(matrix, b);

        StringBuilder sb = new StringBuilder();
        for (int[] m : result) {
            for (int i : m) {
                sb.append(i).append(" ");
            }
            sb.toString().trim();
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] pow(int[][] A, long exp) {
        if (exp == 1) return A;
        int[][] mat = pow(A, exp / 2);
        mat = multiply(mat, mat);
        if (exp % 2 == 1) {
            mat = multiply(mat, matrix);
        }
        return mat;
    }


    static int[][] multiply(int[][] A, int[][] B) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[i][j] += A[i][k] * B[k][j];
                    mat[i][j] %= 1000;
                }
            }
        }

        return mat;
    }

}