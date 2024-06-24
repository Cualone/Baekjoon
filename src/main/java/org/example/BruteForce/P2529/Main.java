package org.example.BruteForce.P2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[] sign;
    static int[] result;
    static boolean[] visited;
    static long max, min;
    static String maxResult, minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sign = new char[N];
        result = new int[N + 1];
        visited = new boolean[10];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        maxResult = "";
        minResult = "";

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        solve(0);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void solve(int cnt) {
        if (cnt == N + 1) {
            if (correct()) {
                long temp = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= N; i++) {
                    sb.append(result[i]);
                }
                temp = Long.parseLong(String.valueOf(sb));
                if (temp > max) {
                    max = temp;
                    maxResult = sb.toString();
                }
                if (temp < min) {
                    min = temp;
                    minResult = sb.toString();
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cnt] = i;
                solve(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static boolean correct() {
        for (int i = 0; i < N; i++) {
            char c = sign[i];
            if (c == '<') {
                if (result[i] >= result[i + 1]) return false;
            } else if (c == '>') {
                if (result[i] <= result[i + 1]) return false;
            }
        }
        return true;
    }
}
