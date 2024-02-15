package org.example.P1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int cnt = 0;

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();
        HashSet<Integer> comp = new HashSet<>(A);

        StringTokenizer eleA = new StringTokenizer(br.readLine());
        for (int i = 0; i < numA; i++) {
            A.add(Integer.parseInt(eleA.nextToken()));
        }
        StringTokenizer eleB = new StringTokenizer(br.readLine());
        for (int i = 0; i < numB; i++) {
            B.add(Integer.parseInt(eleB.nextToken()));
        }

        comp.removeAll(B);
        B.removeAll(A);

        cnt = comp.size() + B.size();

        System.out.println(cnt);
    }
}
