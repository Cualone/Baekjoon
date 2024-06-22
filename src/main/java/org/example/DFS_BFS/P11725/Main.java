package org.example.DFS_BFS.P11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Integer>> graph;
    static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        par = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 노드별 리스트 초기화
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(par[i]);
        }



    }

    static void dfs(int i) {
        boolean[] visited = new boolean[N+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        visited[i] = true;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int next : graph.get(curr)) { // 인접 리스트를 사용한 반복
                if (!visited[next]) {
                    par[next] = curr;
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }
    }
}
