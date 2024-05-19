package org.example.P1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static int[][] graph = new int[1001][1001];
    static boolean[] visited_dfs = new boolean[1001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);

    }

    static void dfs(int node) {
        visited_dfs[node] = true;
        sb.append(node).append(" ");
        for (int next = 1; next <= N; next++) {
            if (!visited_dfs[next] && graph[node][next] != 0) {
                dfs(next);
            }
        }
    }

    static void bfs(int node) {
        boolean[] visited = new boolean[1001];
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");

            for (int next = 1; next <= N; next++) {
                if (!visited[next] && graph[curr][next] != 0) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
