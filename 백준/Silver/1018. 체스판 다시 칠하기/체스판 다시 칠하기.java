//package template_baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int answer = Integer.MAX_VALUE;
        for (int x = 0; x < n - 7; x++) {
            for (int y = 0; y < m - 7; y++) {
                answer = Math.min(answer, originalCheck(x, y));
            }
        }

        System.out.println(answer);
    }



    static int originalCheck(int x, int y) {
        int count = 0;
        boolean nextIsW = (map[x][y] == 'B');
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (nextIsW) {
                    if (map[i + x][j + y] == 'B') {
                        count++;
                    }
                    nextIsW = false;
                } else {
                    if (map[i + x][j + y] == 'W') {
                        count++;
                    }
                    nextIsW = true;
                }
            }
            nextIsW = !nextIsW;
        }

        return Math.min(count, 64 - count);
    }
}