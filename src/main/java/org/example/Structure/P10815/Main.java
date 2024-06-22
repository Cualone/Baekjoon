package org.example.Structure.P10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> cardSet = new HashSet<Integer>();

        StringTokenizer sgCard = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cardSet.add(Integer.valueOf(sgCard.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer compCard = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (cardSet.contains(Integer.valueOf(compCard.nextToken()))) {
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb);
    }
}
