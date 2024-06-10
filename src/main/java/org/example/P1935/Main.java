package org.example.P1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] nums = new double[N];
        ArrayDeque<Double> stack = new ArrayDeque<>();

        String form = br.readLine();

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < form.length(); i++) {
            if (form.charAt(i) >= 'A' && form.charAt(i) <= 'Z') {
                stack.push(nums[form.charAt(i) - 'A']);
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (form.charAt(i)) {
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());

    }
}
