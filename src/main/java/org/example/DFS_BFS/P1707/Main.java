package org.example.DFS_BFS.P1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] check;
    static boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            result = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            // node
            int V = Integer.parseInt(st.nextToken());
            // edge
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            for (int j = 0; j < V + 1; j++) {
                graph[j] = new ArrayList<>();
            }
            visited = new boolean[V + 1];
            check = new boolean[V + 1];
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            for (int j = 1; j <= V; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    dfs(j);
                    if(result) break;
                }
            }
            if(result) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb);
    }

    static void dfs(int index) {

        for (int next : graph[index]) {
            if (!visited[next]) {
                visited[next] = true;
                check[next] = !check[index];
                dfs(next);
            } else if (check[next] == check[index]) {
                result = true;
                return;
            }
        }
    }
}
