package org.example.MATH.P2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int five = N/5;
        int cnt = -1;

        while (five>-1) {
            if ((N - (5 * five)) % 3 == 0) {
                cnt = five + ((N - (5 * five)) / 3);
                break;
            }
            five--;
        }



        System.out.println(cnt);
    }
}
