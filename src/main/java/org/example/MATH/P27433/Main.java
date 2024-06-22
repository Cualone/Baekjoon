package org.example.MATH.P27433;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(facto(N));

    }

    static long facto(int num) {
        if (num < 1) {
            return 1;
        }
        return num * facto(num-1);
    }
}
