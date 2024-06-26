package org.example.MATH.P2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i=0; i<5; i++) {
            int a = Integer.parseInt(st.nextToken());
            result += a*a;
        }
        System.out.println(result%10);
    }
}
