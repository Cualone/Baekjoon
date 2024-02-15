package org.example.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        HashSet<String> name = new HashSet<>();
        HashSet<String> dbj = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            name.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String motName = br.readLine();
            if (name.contains(motName)) {
                dbj.add(motName);
                cnt++;
            }
        }

        System.out.println(cnt);
        dbj.stream().sorted().forEach(System.out::println);
    }
}
