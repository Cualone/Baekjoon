package org.example.P5073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] side = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            side[0] = Integer.parseInt(st.nextToken());
            side[1] = Integer.parseInt(st.nextToken());
            side[2] = Integer.parseInt(st.nextToken());

            if (side[0] + side[1] + side[2] == 0)
                return;

            Arrays.sort(side);

            if(side[2] >= side[0] + side[1]) {
                System.out.println("Invalid");
            }else if(side[0] == side[1] && side[1] == side[2]) {
                System.out.println("Equilateral");
            }else if(side[0] == side[1] || side[1] == side[2] || side[0] == side[2]) {
                System.out.println("Isosceles");
            }else {
                System.out.println("Scalene");
            }

        }
    }
}
