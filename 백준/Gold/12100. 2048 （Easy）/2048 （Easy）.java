
import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        game(0);
        System.out.println(answer);

    }


    static void game(int count) {
        if (count == 5) {
            findMax();
            return;
        }
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = board[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            game(count + 1);
            for (int x = 0; x < n; x++) {
                board[x] = copy[x].clone();
            }
        }
    }

    static void move(int dir) {
        if (dir == 0) { //상
            for (int j = 0; j < n; j++) {
                int index = 0;
                int block = 0;
                for (int i = 0; i < n; i++) {
                    if (board[i][j] != 0) {
                        if (block == board[i][j]) {
                            board[index - 1][j] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[index][j] = block;
                            index++;
                        }
                    }
                }
            }
        } else if (dir == 1) { //하
            for (int j = 0; j < n; j++) {
                int index = n - 1;
                int block = 0;
                for (int i = n - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        if (block == board[i][j]) {
                            board[index + 1][j] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[index][j] = block;
                            index--;
                        }
                    }
                }
            }
        } else if (dir == 2) { //좌
            for (int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        if (block == board[i][j]) {
                            board[i][index - 1] = block * 2;
                            board[i][j] = 0;
                            block = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        } else { //우
            for (int i = 0; i < n; i++) {
                int index = n - 1;
                int block = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        if (block == board[i][j]) {
                            board[i][index + 1] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        }
    }

    static void findMax() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
    }
}

