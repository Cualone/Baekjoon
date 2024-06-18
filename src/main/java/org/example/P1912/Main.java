package org.example.P1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int current = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
