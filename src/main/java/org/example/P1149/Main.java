package org.example.P1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        * 0 = R
        * 1 = G
        * 2 = B
        * */
        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]);
                        break;
                    case 1:
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]);
                        break;
                    case 2:
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]);
                        break;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (dp[N-1][i] < result) result = dp[N - 1][i];
        }

        System.out.println(result);
    }
}
