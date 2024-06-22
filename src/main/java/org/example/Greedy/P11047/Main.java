package org.example.Greedy.P11047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int won = sc.nextInt();
        int[] coin = new int[line];
        int cnt=0;
        int remain = won;

        for(int i=0;i<line;i++) {
            int value = sc.nextInt();
            coin[i] = value;
        }

        for(int i=line-1;i>=0;i--) {
            if (won/coin[i]==0) {
                continue;
            } else {
                cnt += remain / coin[i];
                remain = remain % coin[i];
            }
        }

        System.out.println(cnt);
    }
}
