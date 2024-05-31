package org.example.P1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer[]>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Integer[] {b, cost});
            graph[b].add(new Integer[] {a, cost});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            System.out.println(dfs(a, b, 0));
        }
    }

    static int dfs(int start, int end, int cnt) {
        visited[start] = true;
        if (start == end) return cnt;
        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i)[0];
            if (!visited[next]) {
                int result = dfs(next, end, cnt + graph[start].get(i)[1]);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }
}
