package org.example.P10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];

        for (int i = 0; i < line.length(); i++) {
            alphabet[line.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < alphabet.length; i++) {
            sb.append(alphabet[i]).append(" ");
        }

        System.out.println(sb);
    }
}
