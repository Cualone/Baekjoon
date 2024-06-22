package org.example.DFS_BFS.P11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int node) {
        Stack<Integer> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited[cur]) continue;

            visited[cur] = true;
            for (int next = 1; next <= N; next++) {
                if (!visited[next] && graph[cur][next] != 0) {
                    stack.push(next);
                }
            }
        }
    }
}
