package org.example.P10799_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String stick = br.readLine();
        int result = 0;

        for (int i = 0; i < stick.length(); i++) {
            if (stick.charAt(i) == '(') {
                stack.push(stick.charAt(i));
            } else {
                stack.pop();
                if (stick.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
