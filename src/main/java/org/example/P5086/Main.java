package org.example.P5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0 && y == 0) {
                break;
            } else if (x % y == 0) {
                System.out.println("multiple");
            } else if (y % x == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
        br.close();
    }
}
