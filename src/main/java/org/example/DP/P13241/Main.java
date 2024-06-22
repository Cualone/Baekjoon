package org.example.DP.P13241;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long longA = Long.parseLong(st.nextToken());long longB = Long.parseLong(st.nextToken());
        long a = longA, b = longB, temp;

        while( b != 0 ){

            temp = a % b;
            a = b;
            b = temp;

        }
        System.out.println(longA * longB / a);
    }
}