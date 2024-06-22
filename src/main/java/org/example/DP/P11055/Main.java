package org.example.DP.P11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
            for (int j = i; j >= 0; j--) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }
}
