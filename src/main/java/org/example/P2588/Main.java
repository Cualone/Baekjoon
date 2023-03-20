package org.example.P2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int n1 = Integer.parseInt(str[2]);
        int n2 = Integer.parseInt(str[1]);
        int n3 = Integer.parseInt(str[0]);
        System.out.println(num*n1);
        System.out.println(num*n2);
        System.out.println(num*n3);
        System.out.println(num*n1+num*n2*10+num*n3*100);

        br.close();
    }
}

