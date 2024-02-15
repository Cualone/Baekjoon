package org.example.P11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        HashSet<String> list = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                list.add(S.substring(i, j+1));
            }
        }

        System.out.println(list.size());
    }
}
