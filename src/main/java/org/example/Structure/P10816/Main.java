package org.example.Structure.P10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> card = new HashMap<Integer, Integer>();
        StringTokenizer sgCard = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(sgCard.nextToken());
            if (card.containsKey(num)) {
                card.put(num, card.get(num) + 1);
            } else {
                card.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer compCard = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(compCard.nextToken());
            if (card.containsKey(num)) {
                sb.append(card.get(num)).append(" ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
