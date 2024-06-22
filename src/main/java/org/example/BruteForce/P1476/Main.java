package org.example.BruteForce.P1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // mod 연산으로는 각 최대값이 나올 수 없기 때문에 0으로 치환
        E = (E == 15) ? 0 : E;
        S = (S == 28) ? 0 : S;
        M = (M == 19) ? 0 : M;

        int n = 1;
        while (true) {
            if (n % 15 == E && n % 28 == S && n % 19 == M) {
                System.out.println(n);
                return;
            }
            n++;
        }
    }
}
