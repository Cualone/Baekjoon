package org.example.DFS_BFS.P2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int [][] matrix = new int[101][101];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());

        for (int i = 0; i < link; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = matrix[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt - 1);
    }

    static void dfs(int node) {
        boolean[] visited = new boolean[101];

        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            cnt++;
            for (int next =1;next < 101;next++) {
                if (!visited[next] && matrix[curr][next] != 0) {
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }
    }
}
