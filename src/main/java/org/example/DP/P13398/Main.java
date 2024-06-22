package org.example.DP.P13398;

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

        int[] foreDp = new int[n];
        int[] backDp = new int[n];
        int max = Integer.MIN_VALUE;

        foreDp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            foreDp[i] = Math.max(arr[i], foreDp[i - 1] + arr[i]);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, foreDp[i]);
        }

        backDp[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            backDp[i] = Math.max(arr[i], backDp[i + 1] + arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, foreDp[i - 1] + backDp[i + 1]);
        }

        System.out.println(max);
    }
}
