package org.example.DP.P1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cage = new int[N][3];

        for (int i = 0; i < 3; i++) {
            cage[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            cage[i][0] = (cage[i - 1][0] + cage[i - 1][1] + cage[i - 1][2]) % 9901;
            cage[i][1] = (cage[i - 1][0] + cage[i - 1][2]) % 9901;
            cage[i][2] = (cage[i - 1][0] + cage[i - 1][1]) % 9901;
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += cage[N - 1][i];
        }

        System.out.println(result % 9901);
    }
}
