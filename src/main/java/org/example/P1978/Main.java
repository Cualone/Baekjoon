package org.example.P1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = n;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 1)
                cnt--;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
