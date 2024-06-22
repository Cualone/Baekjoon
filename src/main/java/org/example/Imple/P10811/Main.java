package org.example.Imple.P10811;

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
        int[] basket = new int[n];
        for (int x = 0 ; x < n ; x++) {
            basket[x] = x+1;
        }
        for (int y = 0 ; y < m ; y++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st2.nextToken())-1;
            int j = Integer.parseInt(st2.nextToken())-1;
            int[] alt = new int[j-i+1];
            for (int z = i ; z <= j ; z++) {
                alt[j-z] = basket[z];
            }
            for (int z = i ; z <= j ; z++) {
                basket[z] = alt[z - i];
            }
        }
        for (int baskets : basket) {
            System.out.print(baskets + " ");
        }

    }
}
