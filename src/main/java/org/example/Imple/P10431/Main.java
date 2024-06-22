package org.example.Imple.P10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            System.out.print(t + " ");
            List<Integer> height = new ArrayList<>();
            String[] split = br.readLine().split(" ");

            int where, cnt = 0;
            height.add(Integer.parseInt(split[1]));

            for (int i = 2; i < 21; i++) {
                int now = Integer.parseInt(split[i]);

                where = -1;
                for (int j = 0; j < i - 1; j++) {
                    if (height.get(j) > now) {
                        where = j;
                        break;
                    }
                }
                if (where == -1) {
                    height.add(now);
                } else {
                    height.add(where, now);
                    cnt += height.size() - where - 1;
                }
            }
            System.out.println(cnt);
        }
    }
}