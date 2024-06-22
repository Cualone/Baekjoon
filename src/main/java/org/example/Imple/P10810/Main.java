package org.example.Imple.P10810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] basket = new int[n];
        Arrays.fill(basket, 0);
        for (int x = 0 ; x < m ; x++) {
            String[] ball = br.readLine().split(" ");
            int i = Integer.parseInt(ball[0])-1;
            int j = Integer.parseInt(ball[1]);
            int k = Integer.parseInt(ball[2]);
            for (int y = i ; y < j ; y++) {
                basket[y] = k;
            }
        }
        for (int baskets : basket) {
            System.out.print(baskets + " ");
        }
    }
}
