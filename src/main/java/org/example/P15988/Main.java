package org.example.P15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dpTable = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dpTable[1] = 1;
        dpTable[2] = 2;
        dpTable[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            dpTable[i] = (dpTable[i - 1] + dpTable[i - 2] + dpTable[i - 3]) % 1000000009;
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dpTable[n]).append("\n");
        }

        System.out.println(sb);
    }

}
