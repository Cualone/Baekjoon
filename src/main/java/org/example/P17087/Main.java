package org.example.P17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] younger = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            younger[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        if (N == 1) {
            System.out.println(younger[0]);
            return;
        }

        int min = younger[0];
        for (int i = 1; i < N; i++) {
            min = gcd(younger[i], min);
        }


        System.out.println(min);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
