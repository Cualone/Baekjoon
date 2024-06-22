package org.example.Structure.P1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        int idx = 0;
        sb.append('<');
        while (!arr.isEmpty()) {
            idx = (idx + K - 1) % arr.size();
            sb.append(arr.get(idx)).append(", ");
            arr.remove(idx);
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        System.out.println(sb);
    }
}
