package org.example.BruteForce.P1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-7; i++) {
            for (int j = 0; j < m-7; j++) {
                int curMin = solution(i, j, board);
                if(min>curMin) min = curMin;
            }
        }
        System.out.println(min);


    }

    public static int solution(int startRow, int startCol, String[] board) {
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
        int sol = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if(board[row].charAt(col) != orgBoard[row%2].charAt(j)) sol++;
            }
        }
        return Math.min(sol, 64 - sol);
    }

}
