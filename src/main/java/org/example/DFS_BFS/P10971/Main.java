package org.example.DFS_BFS.P10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] route;
    static boolean[] visited;
    static int N;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        route = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 0, 0);
        }
        System.out.println(min);
    }

    static void dfs(int curr, int sum, int cnt) {
        if (cnt == N - 1) {
            if (route[curr][0] != 0) {
                sum += route[curr][0];
                min = Math.min(min, sum);
            }
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next] && route[curr][next] != 0) {
                visited[next] = true;
                dfs(next, sum + route[curr][next], cnt + 1);
                visited[next] = false;
            }
        }
    }
}
