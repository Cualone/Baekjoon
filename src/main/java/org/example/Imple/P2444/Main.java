package org.example.Imple.P2444;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for(int i = 1; i <= num; i++) {
            for(int j = i; j < num; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < i*2-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 2 ; i <= num; i++) {
            for(int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for(int k = (2*num)-(i*2-1); k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
