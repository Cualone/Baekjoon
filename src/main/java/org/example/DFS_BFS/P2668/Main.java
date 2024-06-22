package org.example.DFS_BFS.P2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class Main {
    static ArrayList<Integer[]>[] graph;
    static boolean[] visited;
    static HashSet<Integer> result = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            graph[i].add(new Integer[] {i, num});
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }
        ArrayList<Integer> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        System.out.println(sortedResult.size());
        for (int i = 0; i < sortedResult.size(); i++) {
            System.out.println(sortedResult.get(i));
        }
    }

    static void dfs(int node) {
        ArrayList<Integer> temp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (!visited[cur]) {
                visited[cur] = true;
                temp.add(cur);
                int next = graph[cur].get(0)[1];
                if (!visited[next]) {
                    stack.push(next);
                } else if (next == node) {
                    result.addAll(temp);
                }
            }
        }
    }
}
