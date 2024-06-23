package org.example.MATH.P10973;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i > 0; i--) {
            int idx = i;
            if (arr[i - 1] > arr[i]) {
                for (int j = i; j < N; j++) {
                    if (arr[j] < arr[i - 1] && arr[j] > arr[idx]) {
                        idx = j;
                    }
                }

                swap(i - 1, idx);

                int start = i;
                int end = N - 1;
                while (start < end) {
                    swap(start, end);
                    start++;
                    end--;
                }

                for (int k = 0; k < N; k++) {
                    sb.append(arr[k]).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }

        System.out.println(-1);
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
