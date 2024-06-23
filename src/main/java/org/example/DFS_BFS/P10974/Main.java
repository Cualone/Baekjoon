package org.example.DFS_BFS.P10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr, result;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        result = new int[N];
        visited = new boolean[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        tracking(0);
        System.out.println(sb);
    }

    static void tracking(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                tracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
