package org.example.P17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        * R=0
        * G=1
        * B=2
        * */
        int[][] rgb = new int[N][3];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[N][3];
            Arrays.fill(dp[0], 1001);
            dp[0][i] = rgb[0][i];
            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + rgb[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + rgb[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + rgb[j][2];
            }
            for(int j = 0; j < 3; j++) {
                if (j == i) continue;
                min = Math.min(min, dp[N - 1][j]);
            }
        }

        System.out.println(min);
    }
}
