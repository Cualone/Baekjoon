package org.example.DFS_BFS.P1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer[]> graph[];
    static boolean[] visited;
    static int max = 0;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[parent].add(new Integer[]{child, cost});
            graph[child].add(new Integer[]{parent, cost});
        }
        dfs(1, 0);
        max = 0;
        visited = new boolean[n+1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    static void dfs(int node, int sum) {
        visited[node] = true;
        if (sum > max) {
            max = sum;
            maxNode = node;
        }

        for(int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i)[0];
            int cost = graph[node].get(i)[1];
            if (!visited[next]) {
                dfs(next, sum + cost);
            }
        }
    }
}
