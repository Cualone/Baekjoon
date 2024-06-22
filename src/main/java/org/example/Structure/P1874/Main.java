package org.example.Structure.P1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
