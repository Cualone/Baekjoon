package org.example.P2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] nums = new int[K + 1][N + 1];
        nums[1][0] = 1;
        for (int i = 1; i <= K; i++) {
            nums[i][0] = 1;
        }
        for (int i = 0; i <= N; i++) {
            nums[1][i] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                nums[i][j] = (nums[i][j - 1] + nums[i - 1][j]) % 1_000_000_000;
            }
        }

        System.out.println(nums[K][N]);
    }
}
