package org.example.P2903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 2;
        for (int i = 0; i < n; i++) {
            num += (num-1);
        }

        System.out.println(num * num);
    }
}
