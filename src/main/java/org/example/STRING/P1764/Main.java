package org.example.STRING.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        HashSet<String> name = new HashSet<>();
        List<String> dbj = new ArrayList<>();
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

        Collections.sort(dbj);

        sb.append(cnt).append("\n");
        for (String a : dbj) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);

    }
}
