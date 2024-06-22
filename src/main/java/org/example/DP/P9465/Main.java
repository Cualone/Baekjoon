package org.example.DP.P9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[3][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][0] = sticker[0][0];
            dp[2][0] = sticker[1][0];
            for (int j = 1; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[2][j - 1]);
                dp[1][j] = sticker[0][j] + Math.max(dp[0][j - 1], dp[2][j - 1]);
                dp[2][j] = sticker[1][j] + Math.max(dp[0][j - 1], dp[1][j - 1]);
            }

            int result = 0;
            for (int j = 0; j < 3; j++) {
                if (dp[j][n - 1] > result) result = dp[j][n - 1];
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
