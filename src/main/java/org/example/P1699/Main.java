package org.example.P1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i * i <= N; i++) {
            int sq = i * i;
            // 다음 제곱 수 포함되는 수부터 ++
            for (int j = sq; j <= N; j++) {
                // 이전 제곱수로 만들어진 min dp와 j에서 현재 제곱수를 뺀 수의 min dp에 +1(현재 제곱수로 채움)
                dp[j] = Math.min(dp[j], dp[j - sq] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
