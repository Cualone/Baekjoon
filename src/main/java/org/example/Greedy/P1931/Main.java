package org.example.Greedy.P1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1]));


        int count = 0;
        int prev_end = 0;

        for (int i = 0; i < N; i++) {
            if(prev_end <= time[i][0]) {
                prev_end = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
