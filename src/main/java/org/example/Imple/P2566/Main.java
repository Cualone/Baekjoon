package org.example.Imple.P2566;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] proc = new int[9][9];
        int max = 0;
        int row = 1;
        int col = 1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                proc[i][j] = sc.nextInt();
                if(proc[i][j]>max) {
                    max = proc[i][j];
                    row = i+1;
                    col = j+1;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
