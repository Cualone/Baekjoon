package org.example.P10813;

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
            int num = basket[i];
            basket[i] = basket[j];
            basket[j] = num;
        }

        for (int baskets : basket) {
            System.out.print(baskets + " ");
        }

    }
}
