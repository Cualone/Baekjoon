package org.example.STRING.P10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();

        while ((s = br.readLine()) != null) {
            int lower = 0, upper = 0, num = 0, space = 0;
            for (int i = 0; i < s.length(); i++) {
                if ('a'<=s.charAt(i) && s.charAt(i)<='z') lower++;
                else if ('A'<=s.charAt(i) && s.charAt(i)<='Z') upper++;
                else if ('0'<=s.charAt(i) && s.charAt(i)<='9') num++;
                else space++;
            }
            sb.append(lower).append(" ").append(upper).append(" ").append(num).append(" ").append(space).append("\n");
        }

        System.out.println(sb);
    }
}
