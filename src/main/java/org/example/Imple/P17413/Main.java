package org.example.Imple.P17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();

        boolean check = false;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                check = true;
                sb.append(c);
            } else if (c == '>') {
                check = false;
                sb.append(c);
            } else if (check) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
