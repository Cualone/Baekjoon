package org.example.BruteForce.P14391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] RowOrCol;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        RowOrCol = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        check(0, 0);
        System.out.println(max);

    }

    static void check(int row, int col) {
        if (row == N) {
            sum();
            return;
        }

        if (col == M) {
            check(row + 1, 0);
            return;
        }

        RowOrCol[row][col] = true;
        check(row, col + 1);
        RowOrCol[row][col] = false;
        check(row, col + 1);
    }

    static void sum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < M; j++) {
                if (RowOrCol[i][j]) {
                    temp *= 10;
                    temp += board[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (!RowOrCol[j][i]) {
                    temp *= 10;
                    temp += board[j][i];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        max = Math.max(max, sum);
    }
}
