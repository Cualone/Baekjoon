package org.example.P2231;

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
            int[] arr = new int[num.length()];
            int sum = i;

            for (int j = 0; j < num.length(); j++) {
                arr[j] = Integer.parseInt(String.valueOf(num.charAt(j)));
            }
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
            if (sum == n) {
                result = i;
                break;
            }

        }

        System.out.println(result);

    }

}
