package org.example.P11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>();

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            pq.add(S.substring(i));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
