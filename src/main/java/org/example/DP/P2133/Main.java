package org.example.DP.P2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tile = new int[N + 1];

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        tile[0] = 1;
        tile[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            tile[i] = tile[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                tile[i] += tile[j] * 2;
            }
        }

        System.out.println(tile[N]);
    }
}
