package org.example.Structure.P14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int max = 0;
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) max = dp[i];
        }

        sb.append(max).append("\n");

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.push(A[i]);
                max--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
