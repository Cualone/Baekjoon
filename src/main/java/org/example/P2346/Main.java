package org.example.P2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Balloon {
    int index;
    int value;
    public Balloon(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();  //원형
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while (!deque.isEmpty()) {
            sb.append(deque.peekFirst().index).append(" ");

            int next = deque.poll().value;

            if (deque.isEmpty()) {
                break;
            }

            if (next > 0) {
                for (int i = 1; i < next; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(next); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}