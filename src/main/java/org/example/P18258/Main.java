package org.example.P18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    list.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer num = list.poll();
                    if (num == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(num).append("\n");
                    }
                    break;
                case "size":
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    Integer item = list.peek();
                    if (item == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(item).append("\n");
                    }
                    break;
                case "back":
                    Integer bit = list.peekLast();
                    if (bit == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(bit).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
