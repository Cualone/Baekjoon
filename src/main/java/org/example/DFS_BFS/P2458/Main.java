package org.example.DFS_BFS.P2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] upGraph;
    static int[][] downGraph;
    static boolean[] visited;
    static int knownCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        upGraph = new int[N+1][N+1];
        downGraph = new int[N+1][N+1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int down = Integer.parseInt(st.nextToken());
            int up = Integer.parseInt(st.nextToken());
            // down -> up
            upGraph[down][up] = 1;
            // up -> down
            downGraph[up][down] = 1;
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            int up = upDfs(i);
            visited = new boolean[N+1];
            int down = downDfs(i);

            if (up + down == N - 1) knownCnt++;
        }

        System.out.println(knownCnt);

    }

    static int upDfs(int node) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int i = 0; i < upGraph[cur].length; i++) {
                if (upGraph[cur][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static int downDfs(int node) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int i = 0; i < downGraph[cur].length; i++) {
                if (downGraph[cur][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
