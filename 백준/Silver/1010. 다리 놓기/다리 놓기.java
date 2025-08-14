import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i<30; i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int i = 1; i<30; i++) {
            for (int j = 1; j<30; j++) {
                if(dp[i][j] == 0) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }


        for (int i = 0; i<testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[m][n]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

//    static int pascal(int n, int r) {
//        if(dp[n][r] > 0) return dp[n][r];
//
//        if (n == r || r == 0) return dp[n][r] = 1;
//
//        return pascal(n-1, r-1) + pascal(n-1, r);
//    }
}