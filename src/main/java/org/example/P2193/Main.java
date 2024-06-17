package org.example.P2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] binary = new long[N+1][2];

        binary[1][0] = 1;
        binary[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            binary[i][0] = binary[i-1][0] + binary[i-1][1];
            binary[i][1] = binary[i-1][0];
        }

        System.out.println(binary[N][1]);
    }
}
