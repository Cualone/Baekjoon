package org.example.P3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;
    static int max;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        max = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                counting(i, j);
            }
        }

        // 오른쪽과 교환 -> 행, 열 count -> 원복
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                trans(i, j, i, j + 1);
                counting(i, j);
                counting(i, j + 1);
                trans(i, j, i, j + 1);
            }
        }

        // 아래쪽과 교환 -> 행, 열 count -> 원복
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                trans(i, j, i + 1, j);
                counting(i, j);
                counting(i + 1, j);
                trans(i, j, i + 1, j);
            }
        }

        System.out.println(max);
    }

    static void trans(int x, int y, int nx, int ny) {
        char temp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = temp;
    }

    static void counting(int x, int y) {
        char color = board[x][y];
        int row = 1;
        int col = 1;
        // 상 탐색
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] != color) break;
            row++;
        }
        // 하 탐색
        for (int i = x + 1; i < N; i++) {
            if (board[i][y] != color) break;
            row++;
        }
        // 좌 탐색
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] != color) break;
            col++;
        }
        // 우 탐색
        for (int i = y + 1; i < N; i++) {
            if (board[x][i] != color) break;
            col++;
        }
        max = Math.max(max, Math.max(row, col));
    }
}
