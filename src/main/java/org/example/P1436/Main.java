package org.example.P1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 666;
        while (cnt < N) {


            if (isContain(num)) {
                cnt++;
            }
            if(cnt == N) break;

            num++;
        }
        System.out.println(num);
    }

    public static boolean isContain(int num) {
        String numString = Integer.toString(num);
        for (int i = 0; i <= numString.length()-3; i++) {
            if(numString.startsWith("666", i)) return true;
        }
        return false;
    }
}
