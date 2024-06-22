package org.example.Structure.P10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stick = br.readLine();
        int open = 0;
        int result = 0;

        for (int i = 0; i < stick.length(); i++) {
            if (stick.charAt(i) == '(') {
                open++;
            } else if (stick.charAt(i) == ')' && stick.charAt(i - 1) == '(') {
                open--;
                result += open;
            } else {
                open--;
                result++;
            }
        }

        System.out.println(result);
    }
}
