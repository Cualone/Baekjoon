package org.example.MATH.P1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 0;

        int start = 1;
        int end = 9;
        int digit = 1;

        while (start <= N) {
            if (N < end) end = N;
            result += (long) digit * (end - start + 1);
            start *= 10;
            end = start * 10 - 1;
            digit++;
        }

        System.out.println(result);
    }
}
