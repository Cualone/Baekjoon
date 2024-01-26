package org.example.P5073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] side = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            if (side[0] + side[1] + side[2] == 0)
                return;

            int max = 0;
            int maxi = 0;
            int other = 0;
            for (int i = 0; i < 3; i++) {
                if (side[i] > max) {
                    max = side[i];
                    maxi = i;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (i == maxi) {
                    continue;
                }
                other += side[i];
            }

            if (max >= other) {
                System.out.println("Invalid");
                continue;
            }

            if (side[0] == side[1] && side[1] == side[2]) {
                System.out.println("Equilateral");
            } else if (side[0] == side[1] || side[1] == side[2] || side[0] == side[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }





        }
    }
}
