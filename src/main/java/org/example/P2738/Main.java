package org.example.P2738;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] proc1 = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                proc1[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                proc1[i][j] += sc.nextInt();
                System.out.print(proc1[i][j] + " ");
            }
            System.out.print("\n");
        }


    }
}
