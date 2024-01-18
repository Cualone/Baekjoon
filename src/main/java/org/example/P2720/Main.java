package org.example.P2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(num/25 + " ");
            num %= 25;
            sb.append(num/10 + " ");
            num %= 10;
            sb.append(num/5 + " ");
            num %= 5;
            sb.append(num + "\n");
        }
        System.out.println(sb);
        br.close();


    }
}
