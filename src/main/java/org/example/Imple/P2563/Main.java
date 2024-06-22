package org.example.Imple.P2563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        boolean[][] rec = new boolean[100][100];
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int j = n; j < n + 10; j++) {
                for (int k = m; k < m + 10; k++) {
                    rec[j][k] = true;
                }
            }
        }

        for (boolean[] i : rec) {
            for (boolean j : i) {
                if(j == true)
                    count++;
            }
        }

        System.out.println(count);
    }
}
