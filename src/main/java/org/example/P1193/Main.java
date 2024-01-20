package org.example.P1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int cnt = 1;
        int sum = 0;

        while (true) {
            n -= cnt;
            if (n <= 0) {
                n += cnt;
                break;
            }
            cnt++;
        }

        if (cnt % 2 == 0) {
            System.out.println(n + "/" + (cnt + 1 - n));
        } else {
            System.out.println((cnt + 1 - n) + "/" + n);
        }

    }
}
