package org.example.Structure.P12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> got = new Stack<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        got.push(0);

        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        while (!queue.isEmpty()) {
            if (queue.peek().equals(got.peek() + 1)) {
                got.push(queue.poll());
            } else if (!stack.empty() && stack.peek().equals(got.peek() + 1)) {
                got.push(stack.pop());
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.empty()) {
            if (stack.peek().equals(got.peek() + 1)) {
                got.push(stack.pop());
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");

    }
}
