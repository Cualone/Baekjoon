package org.example.BruteForce.P2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String num = Integer.toString(i);
            int sum = i;

            for (int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }
            if (sum == n) {
                result = i;
                break;
            }

        }

        System.out.println(result);

    }

}
