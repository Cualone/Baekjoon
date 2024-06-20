package org.example.P1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }


        int totalMin = Math.abs(N - 100);

        for (int i = 0; i < 999_999; i++) {
            String number = Integer.toString(i);
            boolean check = true;
            for (int j = 0; j < number.length(); j++) {
                if (broken[number.charAt(j) - '0']) {
                    check = false;
                    break;
                }
            }
            if (check) {
                totalMin = Math.min(totalMin, number.length() + Math.abs(i - N));
            }
        }

        System.out.println(totalMin);
    }
}
