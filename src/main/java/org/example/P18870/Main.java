package org.example.P18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sort = new int[N];

        HashMap<Integer, Integer> rank = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sort[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sort);

        int cnt = 0;
        for (int i = 0; i < sort.length; i++) {
            if (!rank.containsKey(sort[i])) {
                rank.put(sort[i], cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < origin.length; i++) {
            sb.append(rank.get(origin[i])).append(" ");
        }

        System.out.println(sb);
    }
}
