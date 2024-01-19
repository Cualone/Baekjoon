package org.example.P2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());   //up
        int b = Integer.parseInt(st.nextToken());   //down
        int v = Integer.parseInt(st.nextToken());   //stick

        int day = (int) Math.ceil((double)(v-a)/(a-b));

        System.out.println(day + 1);
    }
}
