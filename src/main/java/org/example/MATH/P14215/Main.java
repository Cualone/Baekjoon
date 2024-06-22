package org.example.MATH.P14215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] side = new int[3];

        side[0] = Integer.parseInt(st.nextToken());
        side[1] = Integer.parseInt(st.nextToken());
        side[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(side);

        if (side[2] < side[0] + side[1]) {
            System.out.println(side[0] + side[1] + side[2]);
        } else {
            System.out.println((side[0] + side[1]) * 2 - 1);
        }
    }
}
