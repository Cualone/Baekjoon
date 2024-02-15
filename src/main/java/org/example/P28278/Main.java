package org.example.P28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else {
                judge(command);
            }
        }

        System.out.println(sb);
    }

    public static void judge(int num) {
        switch (num) {
            case 2:
                if (!stack.empty()) {
                    sb.append(stack.pop()).append("\n");
                    break;
                } else {
                    sb.append(-1).append("\n");
                    break;
                }
            case 3:
                sb.append(stack.size()).append("\n");
                break;
            case 4:
                if (stack.empty()) {
                    sb.append(1).append("\n");
                    break;
                } else {
                    sb.append(0).append("\n");
                    break;
                }
            case 5:
                if (!stack.empty()) {
                    sb.append(stack.peek()).append("\n");
                    break;
                } else {
                    sb.append(-1).append("\n");
                    break;
                }
        }
    }
}
