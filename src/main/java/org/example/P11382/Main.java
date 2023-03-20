package org.example.P11382;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long n1 = Long.parseLong(str[0]);
        long n2 = Long.parseLong(str[1]);
        long n3 = Long.parseLong(str[2]);
        System.out.println(n1+n2+n3);

        br.close();
    }
}
