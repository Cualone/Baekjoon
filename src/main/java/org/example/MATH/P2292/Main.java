package org.example.MATH.P2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int room = 2;

        while (room <= n) {
            room += 6*cnt++;
        }

        System.out.println(cnt);
    }
}
