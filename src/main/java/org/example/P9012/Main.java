package org.example.P9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        outer:
        for (int i = 0; i < T; i++) {
            Stack<Integer> stack = new Stack<>();
            String paren = br.readLine();
            for (int j = 0; j < paren.length(); j++) {
                if (paren.charAt(j) == '(') {
                    stack.push(1);
                } else if (paren.charAt(j) == ')') {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        sb.append("NO").append("\n");
                        continue outer;
                    }
                }
            }
            if (!stack.empty()) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }
}
