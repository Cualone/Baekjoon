package org.example.Imple.P9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb.append(reverse(st.nextToken())).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static String reverse(String s) {
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            list.add(s.charAt(i));
        }

        Collections.reverse(list);

        for (int i = 0;i<list.size(); i++) {
            sb.append(list.get(i));
        }

        return sb.toString();
    }
}
